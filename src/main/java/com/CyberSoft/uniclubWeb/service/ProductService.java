package com.CyberSoft.uniclubWeb.service;

import com.CyberSoft.uniclubWeb.dto.ProductDetailDto;
import com.CyberSoft.uniclubWeb.dto.ProductDto;
import com.CyberSoft.uniclubWeb.entity.*;
import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
import com.CyberSoft.uniclubWeb.exception.InsertException;
import com.CyberSoft.uniclubWeb.exception.ProductNotFoundException;
import com.CyberSoft.uniclubWeb.payload.request.InsertProductRequest;
import com.CyberSoft.uniclubWeb.repository.*;
import com.CyberSoft.uniclubWeb.service.imp.FileServiceImp;
import com.CyberSoft.uniclubWeb.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    private FileServiceImp fileServiceImp;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;
// Tạo sản phẩm:
    @Transactional
    @Override
    public boolean insertProduct(InsertProductRequest productRequest) {
        boolean isSuccess = false;
//        TODO: saveFile
        fileServiceImp.saveFile(productRequest.getFile());
        try {
//
            ProductEntity productEntity = new ProductEntity(); 
            productEntity.setProductName(productRequest.getProductName());
            // productEntity.pr(productRequest.getPrice());
            productEntity.setImages(productRequest.getFile().getOriginalFilename());
            productEntity.setSku(productRequest.getSku());
            productEntity.setDescription(productRequest.getDescription());
            productEntity.setInformation(productRequest.getInformation());
            productRepository.save(productEntity);
//            Thêm dữ liệu vào bảng product detail
            ProductDetailEntity productDetailEntity = new ProductDetailEntity();
            ProductDetailID id = new ProductDetailID();
            id.setIdProduct(productEntity.getIdProduct());
            id.setIdCategory(productRequest.getIdCategory());
            id.setIdTag(productRequest.getIdTag());
            id.setIdSize(productRequest.getIdSize());
            id.setIdColor(productRequest.getIdColor());

            productDetailEntity.setId(id);
            productDetailEntity.setQuantity(productRequest.getQuantity());
            productDetailRepository.save(productDetailEntity);

            isSuccess = true;
        }catch (Exception e)
        {
            throw new InsertException("Loi them du lieu " + e.getMessage());
        }

        return isSuccess;
    }
        // Khong tra ra ProductEntity de tranh SQL injecttion.
        //    @Cacheable("allProduct")        // nhược điểm: tốn ram, server sập mất cacheable. memcache
            //Bai tap: Chinh sua memcache thanh redis cached o service getAllproduct
            // Có thể setTimeOut Cache bằng thời gian
    // Lấy toàn bộ sản phẩm 
    @Override
    public List<ProductDto> getAllProduct() {
        // lấy toàn bộ danh sách sản phẩm.
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        // Bien Entity thanh DTO
        productEntities.forEach(item -> {
            ProductDto  productDto = new ProductDto();
            productDto.setProductName(item.getProductName());
            productDto.setPrice(item.getPrice());
            productDto.setIdProduct(item.getIdProduct());
            productDto.setDescription(item.getDescription());
            //  "http://localhost:8080/file/" Sau thay the bang link dong
            productDto.setImages( "http://localhost:8080/file/" + item.getImages());
            productDtos.add(productDto);
        });

        return productDtos;
    }
// Get Detail one Product.
    @Override
    public List<ProductDetailDto> getDetailProduct(int idProduct) {
        List<ProductDetailEntity> productDetailEntities = productDetailRepository.findById_IdProduct(idProduct);
        return productDetailEntities.stream()
                .map(product -> new ProductDetailDto(
                        product.getId().getIdProduct(),
                        product.getCategory().getId(),
                        product.getColor().getId(),
                        product.getSize().getId(),
                        product.getQuantity()
                ))
                .toList();
    }
// Xóa sản phẩm
    // Delete product soft, set flag Delete.
    @Override
    public boolean isShowProduct(int IdPProduct) {
        boolean isSuccess = false;
        ProductEntity product = productRepository.findById(IdPProduct).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + IdPProduct));
        if (product.getStatus().equalsIgnoreCase("active") && product != null){
            product.setStatus("deleted");
            productRepository.save(product);
            isSuccess = true;
        }else {
            throw new RuntimeException("The product is currently out of stock for sale.");
        }
        return isSuccess;
    }
    // Hard delete data (Xóa Vĩnh Viễn)
    private ProductDto convertToDto(ProductEntity item) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(item.getProductName());
        productDto.setPrice(item.getPrice());
        productDto.setIdProduct(item.getIdProduct());
        productDto.setDescription(item.getDescription());
        productDto.setImages("http://localhost:8080/file/" + item.getImages());
        return productDto;
    }
    // Tìm kiếm sản phẩm
    @Override
    public List<ProductDto> findProduct(String nameProduct) {
        List<ProductEntity> productFounds = productRepository.findByProductName(nameProduct);
        List<ProductDto> productsFoundDto = new ArrayList<>();
        productFounds.forEach(item -> {
            productsFoundDto.add(convertToDto(item));
        });
        return productsFoundDto;
    }
    // Tìm kiếm sản phẩm đang sale
    @Override
    public List<ProductDto> findProductSale() {
        String status = "active";
        List<ProductEntity> productEntities = productRepository.findByStatus(status);
        if (productEntities.isEmpty()) {
            throw new ProductNotFoundException("Không có sản phẩm nào đang được bán.");
        }
        List<ProductDto>  productForSale = new ArrayList<>();
        productEntities.forEach(item -> {
            productForSale.add(convertToDto(item));
        });
        return productForSale;
    }
    // Sửa sản phẩm
    @Override
    public ProductEntity updateProduct(int idProduct, ProductDto productDto) {
        ProductEntity productEntity = productRepository.findById(idProduct).orElseThrow(() -> new ProductNotFoundException("Không tìm thấy sản phẩm với ID: " + idProduct)); 
        productEntity.setProductName(productDto.getProductName()); 
        productEntity.setPrice(productDto.getPrice());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setImages(productDto.getImages());
        productRepository.save(productEntity);
        return productEntity;
    }
}
