package com.CyberSoft.uniclubWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_product")
    private int idProduct;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "information")
    private String information;
    @Column(name = "price")
    private String price;
    @Column(name = "images")
    private String images;
    @Column(name = "star")
    private String star;
    @Column(name = "description")
    private String description;
    @Column(name = "sku")
    private String sku;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductDetailEntity> productDetails;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardEntity> cardEntities;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetaiEntity> orderDetaiEntities;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<WishlistEntity> wishlistEntities;
}
