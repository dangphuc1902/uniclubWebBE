package com.CyberSoft.uniclubWeb.entity;

import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
import com.CyberSoft.uniclubWeb.service.imp.ProductServiceImp;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "productdetail")
public class ProductDetailEntity {
    @EmbeddedId
    private ProductDetailID id;

//    Map quan hệ về nhà map.
    @Column(name = "Soluong")
    private int soLuong;
    public ProductDetailID getId(){
        return id;
    }
    public void setId(ProductDetailID id){
        this.id =id;
    }
}
