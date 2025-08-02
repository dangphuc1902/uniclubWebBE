package com.CyberSoft.uniclubWeb.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class InsertProductRequest {
    private transient MultipartFile file;       // transien: de bo gson
    private String productName;
    private String price;
    private String description;
    private String information;
    private int star;
    private String sku;
    private String createAt;
    private String updateAt;
    private String updateBy;
    private String status;
    private int idTag;
    private int idCategory;
    private int idColor;
    private int idSize;
    private int quantity;
    public MultipartFile getFile() {
        return file;
    }
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getInformation() {
        return information;
    }
    public void setInformation(String information) {
        this.information = information;
    }
    public int getStar() {
        return star;
    }
    public void setStar(int star) {
        this.star = star;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getCreateAt() {
        return createAt;
    }
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
    public String getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
    public String getUpdateBy() {
        return updateBy;
    }
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
    

}
