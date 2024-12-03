package com.CyberSoft.uniclubWeb.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orderDetail")
public class OrderDetaiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ID_product")
    private int idProduct;

    @Column(name = "price")
    private double priceProduct;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "size_name")
    private String sizeProduct;
}
