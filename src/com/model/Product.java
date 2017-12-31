package com.model;

import com.sun.javafx.beans.IDProperty;


import java.math.BigDecimal;
import java.util.Date;


public class Product {
    private int productId;
    private String productName;
    private double price;
    private String description;
    private String imageUrl;
    private int typeId;
    private int superTypeId;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSuperTypeId() {
        return superTypeId;
    }

    public void setSuperTypeId(int superTypeId) {
        this.superTypeId = superTypeId;
    }

    public int getProductId() { return productId; }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
