package com.CyberSoft.uniclubWeb.service;

import com.CyberSoft.uniclubWeb.dto.ProductDetailDto;
import com.CyberSoft.uniclubWeb.dto.ProductDto;
import com.CyberSoft.uniclubWeb.entity.*;
import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
import com.CyberSoft.uniclubWeb.exception.InsertException;
import com.CyberSoft.uniclubWeb.exception.ProductNotFoundException;
import com.CyberSoft.uniclubWeb.payload.request.InsertProductRequest;
import com.CyberSoft.uniclubWeb.payload.resoponse.BaseResponse;
import com.CyberSoft.uniclubWeb.repository.*;
import com.CyberSoft.uniclubWeb.service.imp.FileServiceImp;
import com.CyberSoft.uniclubWeb.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    private FileServiceImp fileServiceImp;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CardReponsitory cardReponsitory;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private TagRepository tagRepository;
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
            productEntity.setPrice(productRequest.getPrice());
            productEntity.setImages(productRequest.getFile().getOriginalFilename());
            productEntity.setSku(productEntity.getSku());
            productEntity.setDescription(productEntity.getDescription());
            productEntity.setInformation(productEntity.getInformation());
            productRepository.save(productEntity);

//            Thêm dữ lieệu vào bảng product detail
            ProductDetailEntity productDetailEntity = new ProductDetailEntity();

            ProductDetailID id = new ProductDetailID();
            id.setIdProduct(productEntity.getIdProduct());
            id.setIdCategory(productRequest.getIdCategory());
            id.setIdTag(productRequest.getIdTag());
            id.setIdSize(productRequest.getIdSize());
            id.setIdColor(productRequest.getIdColor());

            productDetailEntity.setId(id);
            productDetailEntity.setSoLuong(productRequest.getSoLuong());
            productDetailRepository.save(productDetailEntity);

            isSuccess = true;
        }catch (Exception e)
        {
            throw new InsertException("Loi them du lieu " + e.getMessage());
        }

        return false;
    }
// Khong tra ra ProductEntity de tranh SQL injecttion.
//    @Cacheable("allProduct")        // nhược điểm: tốn ram, server sập mất cacheable. memcache
    //Bai tap: Chinh sua memcache thanh redis cached o service getAllproduct
    // Có thể setTimeOut Cache bằng thời gian
    @Override
    public List<ProductDto> getAllProduct() {
        System.out.println("Kiểm tra Product");
        // lấy toàn bộ danh sách sản phẩm.
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        // Bien Entity thanh DTO
        productEntities.forEach(item -> {
            ProductDto  productDto = new ProductDto();
            productDto.setTensp(item.getProductName());
            productDto.setGia(item.getPrice());
            productDto.setIdSanPham(item.getIdProduct());
            productDto.setDesc(item.getDescription());
            //  "http://localhost:8080/file/" Sau thay the bang link dong
            productDto.setImage( "http://localhost:8080/file/" + item.getImages());
            productDtos.add(productDto);
        });

        return productDtos;
    }
// Get Detail one Product.
    @Override
    public List<ProductDetailDto> getDetailProduct(int idProduct) {
        // lấy toàn bộ danh sách sản phẩm.
        List<ProductDetailEntity> productDetailEntities = productDetailRepository.findById_IdProduct(idProduct);
        List<ProductDetailDto> productDetailDtos = productDetailEntities.stream().map(
                product -> new ProductDetailDto(
                        product.getId().getIdProduct(),
                        product.getCategory().getId(),
                        product.getColor().getId(),
                        product.getSize().getId(),
                        product.getSoLuong()
                )
        ).toList();
        return productDetailDtos;
    }
    // Delete product soft, set flag Delete.
    @Override
    public boolean isShowProduct(int IdPProduct) {
        boolean isSuccess = false;
        ProductEntity product = productRepository.findById(IdPProduct).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + IdPProduct));
        if (product.isOpen()){
            product.setOpen(false);
            productRepository.save(product);
            isSuccess = true;
        }else {
            throw new RuntimeException("The product is currently out of stock for sale.");
        }
        return isSuccess;
    }
    // Hard delete data (Xóa Vĩnh Viễn)

    @Override
    public List<ProductDto> findProduct(String nameProduct) {
        List<ProductEntity> productFounds = productRepository.findByProductName(nameProduct);
        List<ProductDto> productsFoundDto = new ArrayList<>();
        productFounds.forEach(item -> {
            ProductDto  productDto = new ProductDto();
            productDto.setTensp(item.getProductName());
            productDto.setGia(item.getPrice());
            productDto.setIdSanPham(item.getIdProduct());
            productDto.setDesc(item.getDescription());
            productDto.setImage( "http://localhost:8080/file/" + item.getImages());
            productsFoundDto.add(productDto);
        });
        return productsFoundDto;
    }

    @Override
    public List<ProductDto> findProductSale() {
        List<ProductEntity> productEntities = productRepository.findAllByOpen();
        List<ProductDto>  productForSale = new ArrayList<>();
        productEntities.forEach(item -> {
            ProductDto  productDto = new ProductDto();
            productDto.setTensp(item.getProductName());
            productDto.setGia(item.getPrice());
            productDto.setIdSanPham(item.getIdProduct());
            productDto.setDesc(item.getDescription());
            productDto.setImage( "http://localhost:8080/file/" + item.getImages());
            productForSale.add(productDto);
        });
        return productForSale;
    }

    @Override
    public boolean isDeleteProduct(int idProduct) {
        BaseResponse baseResponse = new BaseResponse();
        boolean isDeleteSuccess = false;
        if (!productRepository.existsById(idProduct)){
            throw new ProductNotFoundException("Product with ID " + idProduct + " not found");
        }
        if (!categoryRepository.existsById(idProduct) || !colorRepository.existsById(idProduct) || !sizeRepository.existsById(idProduct) || !tagRepository.existsById(idProduct)){
            throw  new
        }
        if (categoryEntity.)
        WishlistEntity wishlist = wishlistRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("WishlistEntity with ID " + idProduct + " not found"));
        ReviewEntity reviewEntity = reviewRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("ReviewEntity with ID " + idProduct + " not found"));
        OrderDetailEntity orderDetail = orderDetailRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("OrderDetailEntity with ID " + idProduct + " not found"));
        CardEntity cardEntity = cardReponsitory.findById(idProduct).orElseThrow(() -> new RuntimeException ("CardEntity with ID " + idProduct + " not found"));
        return false;
    }

}
