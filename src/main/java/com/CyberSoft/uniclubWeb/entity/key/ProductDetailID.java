package com.CyberSoft.uniclubWeb.entity.key;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductDetailID implements Serializable {

    private int idProduct;
    private int idTag;
    private int idCategory;
    private int idColor;
    private int idSize;

    public ProductDetailID() {
    }

    public ProductDetailID(int idProduct, int idTag, int idCategory, int idColor, int idSize) {
        this.idProduct = idProduct;
        this.idTag = idTag;
        this.idCategory = idCategory;
        this.idColor = idColor;
        this.idSize = idSize;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetailID that = (ProductDetailID) o;
        return idProduct == that.idProduct &&
                idTag == that.idTag &&
                idCategory == that.idCategory &&
                idColor == that.idColor &&
                idSize == that.idSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idTag, idCategory, idColor, idSize);
    }
}
