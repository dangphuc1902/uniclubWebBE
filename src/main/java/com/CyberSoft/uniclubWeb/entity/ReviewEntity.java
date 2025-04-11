package com.CyberSoft.uniclubWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "avatar_customer")
    private String avatarCustomer;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "email_customer")
    private String emailCustomer;

    @Column(name = "review_content", columnDefinition = "TEXT")
    private String reviewContent;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private ProductEntity product;

    // Getters and Setters
}
