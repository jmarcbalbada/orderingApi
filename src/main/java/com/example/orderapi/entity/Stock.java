package com.example.orderapi.entity;
import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private int quantity;
    private int shopNo;

    // Getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getShopNo() {
        return shopNo;
    }

    public void setShopNo(int shopNo) {
        this.shopNo = shopNo;
    }
}
