package com.CyberSoft.uniclubWeb.dto;
import com.CyberSoft.uniclubWeb.entity.CategoryEntity;
import com.CyberSoft.uniclubWeb.entity.ColorEntity;
import com.CyberSoft.uniclubWeb.entity.ProductEntity;
import com.CyberSoft.uniclubWeb.entity.SizeEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDetailDto {
    private int idProduct;
    private int idTag;
    private int idCategory;
    private int idColor;
    private int idSize;
    private int idQuantity;

    public ProductDetailDto(int idProduct, int idCategory, int idColor, int idSize, int idQuantity) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.idColor = idColor;
        this.idSize = idSize;
        this.idQuantity = idQuantity;
    }

    public ProductDetailDto(ProductEntity product, CategoryEntity category, ColorEntity color, SizeEntity size, int soLuong) {
    }
}
