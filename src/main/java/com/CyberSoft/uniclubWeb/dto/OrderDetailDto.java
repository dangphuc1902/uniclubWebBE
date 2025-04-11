package com.CyberSoft.uniclubWeb.dto;

public class OrderDetailDto {
    private int productId;
    private int quantity;
    private double price;
    private String orderDate;
    private String sizeProduct;

    // Default constructor
    public OrderDetailDto() {}

    // Constructor
    public OrderDetailDto(int productId, int quantity, double price, String orderDate, String sizeProduct) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
        this.sizeProduct = sizeProduct; 
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public String getSizeProduct() { return sizeProduct; }
    public void setSizeProduct(String sizeProduct) { this.sizeProduct = sizeProduct; }
} 