package com.CyberSoft.uniclubWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id_color")
    private ColorEntity color;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private SizeEntity size;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    // Getters and Setters
}
