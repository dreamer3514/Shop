package com.model;

public class CartItem {
    private int productId;
    private int count;
    private int userId;
    private Product product;
    private double total;

    public CartItem(){};
    public CartItem(int pid,int count,int uid,Product p)
    {
        this.productId=pid;
        this.count = count;
        this.userId= uid;
        this.product = p;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal()
    {
        return count*product.getPrice();
    }
}
