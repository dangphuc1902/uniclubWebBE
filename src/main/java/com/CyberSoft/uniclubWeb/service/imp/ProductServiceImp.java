package com.CyberSoft.uniclubWeb.service.imp;

import com.CyberSoft.uniclubWeb.dto.ProductDetailDto;
import com.CyberSoft.uniclubWeb.dto.ProductDto;
import com.CyberSoft.uniclubWeb.entity.ProductEntity;
import com.CyberSoft.uniclubWeb.payload.request.InsertProductRequest;

import java.util.List;

public interface ProductServiceImp {
    boolean insertProduct(InsertProductRequest productRequest);
    List<ProductDto> getAllProduct();
    List<ProductDetailDto> getDetailProduct(int idProduct);
    boolean isDeleteProduct(int IdPProduct);
    List<ProductDto> findProduct(String nameProduct);
    List<ProductDto> findProductSale();
}
