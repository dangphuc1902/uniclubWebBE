package com.CyberSoft.uniclubWeb.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cart")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_product")
    private ProductEntity product;
    @Column(name = "price")
    private double price;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public UserEntity getUsers() {
		return users;
	}
	public void setUsers(UserEntity users) {
		this.users = users;
	}
	@Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity users;
}
