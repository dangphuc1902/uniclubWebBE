package com.CyberSoft.uniclubWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "wishlist")
public class WishlistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_product")
    private ProductEntity idProduct;
    @Column(name = "stock_status")
    private int stockStatus;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity userId;

}
