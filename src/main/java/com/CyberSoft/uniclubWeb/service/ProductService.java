package com.CyberSoft.uniclubWeb.service;

import com.CyberSoft.uniclubWeb.dto.ProductDetailDto;
import com.CyberSoft.uniclubWeb.dto.ProductDto;
import com.CyberSoft.uniclubWeb.entity.ProductDetailEntity;
import com.CyberSoft.uniclubWeb.entity.ProductEntity;
import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
import com.CyberSoft.uniclubWeb.exception.InsertException;
import com.CyberSoft.uniclubWeb.payload.request.InsertProductRequest;
import com.CyberSoft.uniclubWeb.repository.ProductDetailRepository;
import com.CyberSoft.uniclubWeb.repository.ProductRepository;
import com.CyberSoft.uniclubWeb.service.imp.FileServiceImp;
import com.CyberSoft.uniclubWeb.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class ProductService implements ProductServiceImp {
    @Autowired
    private FileServiceImp fileServiceImp;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDetailRepository ProductDetailRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;
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

    @Override
    public List<ProductDetailDto> getDetailProduct() {
        System.out.println("Kiểm tra Product");
        // lấy toàn bộ danh sách sản phẩm.
        List<ProductDetailEntity> productDetailEntities = productDetailRepository.findAll();
        List<ProductDetailDto> productDetailDtosDtos = new ArrayList<>();
        // Bien Entity thanh DTO
        productDetailEntities.forEach(product -> {
            ProductDetailDto  productDetailDto = new ProductDetailDto(product.getId(), product.getSoLuong());

        });

        return productDetailDtosDtos;
    }
}
