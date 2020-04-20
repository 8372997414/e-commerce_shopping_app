package com.example.e_shop;

public class MyOrderItemModel {

    private int productImage;
    private int rating;
    private String productTile;
    private String deliveryStatus;

    public MyOrderItemModel(int productImage,int rating, String productTile, String deliveryStatus) {
        this.productImage = productImage;
        this.rating = rating;
        this.productTile = productTile;
        this.deliveryStatus = deliveryStatus;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTile() {
        return productTile;
    }

    public void setProductTile(String productTile) {
        this.productTile = productTile;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
