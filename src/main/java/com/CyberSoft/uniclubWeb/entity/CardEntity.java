package com.CyberSoft.uniclubWeb.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "card")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_product")
    private ProductEntity idProduct;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity users;
}
