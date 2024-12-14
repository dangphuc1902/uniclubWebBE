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
@Entity(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "avatar_customer")
    private String avataCustomer;
    @Column(name = "name_customer")
    private String nameCustomer;
    @Column(name = "email_customer")
    private String emailCustomer;
    @Column(name = "review_content")
    private String reviewContent;
    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private ProductEntity product;
}
