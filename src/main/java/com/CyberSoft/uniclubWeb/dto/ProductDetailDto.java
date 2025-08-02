package com.CyberSoft.uniclubWeb.dto;
import lombok.Data;

@Data
public class ProductDetailDto {
    private int idProduct;
    private int idTag;
    private int idCategory;
    private int idColor;
    private int idSize;
    private int idQuantity;

    public ProductDetailDto(int idProduct, int idCategory, int idColor, int idSize, int idQuantity) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.idColor = idColor;
        this.idSize = idSize;
        this.idQuantity = idQuantity;
    }

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdTag() {
		return idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public int getIdSize() {
		return idSize;
	}

	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}

	public int getIdQuantity() {
		return idQuantity;
	}

	public void setIdQuantity(int idQuantity) {
		this.idQuantity = idQuantity;
	}

	public ProductDetailDto(int idProduct, int idTag, int idCategory, int idColor, int idSize, int idQuantity) {
		super();
		this.idProduct = idProduct;
		this.idTag = idTag;
		this.idCategory = idCategory;
		this.idColor = idColor;
		this.idSize = idSize;
		this.idQuantity = idQuantity;
	}

	public ProductDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
