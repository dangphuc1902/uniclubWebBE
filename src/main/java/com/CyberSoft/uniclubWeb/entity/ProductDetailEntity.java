package com.CyberSoft.uniclubWeb.entity;

import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetailEntity {

    @EmbeddedId
    private ProductDetailID id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
    private ProductEntity product;
    

	@ManyToOne
    @MapsId("idTag")
    @JoinColumn(name = "id_tag")
    private TagEntity tag;

    @ManyToOne
    @MapsId("idCategory")
    @JoinColumn(name = "id_category")
    private CategoryEntity category;

    @ManyToOne
    @MapsId("idColor")
    @JoinColumn(name = "id_color")
    private ColorEntity color;

    @ManyToOne
    @MapsId("idSize")
    @JoinColumn(name = "id_size")
    private SizeEntity size;

    public ProductDetailID getId() {
		return id;
	}

	public void setId(ProductDetailID id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public TagEntity getTag() {
		return tag;
	}

	public void setTag(TagEntity tag) {
		this.tag = tag;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public SizeEntity getSize() {
		return size;
	}

	public void setSize(SizeEntity size) {
		this.size = size;
	}

    // Getters and Setters
}
