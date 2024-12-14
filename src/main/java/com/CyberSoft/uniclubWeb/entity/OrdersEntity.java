package com.CyberSoft.uniclubWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.springframework.retry.annotation.CircuitBreaker;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "country_region")
    private String countryRegion;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "apartment")
    private String apartment;
    @Column(name = "town_city")
    private String townCity;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private String zip_code;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "note")
    private String note;
    @Column(name = "payment_method")
    private String paymentMethod;
    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity userEntity;
}
