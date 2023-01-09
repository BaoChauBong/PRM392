package com.example.demoproject.Models;

public class OrdersModel {

   int orderImage;
   String soldItemName, priceOrder, orderNumber;

    public OrdersModel(int orderImage, String soldItemName, String priceOrder, String orderNumber) {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.priceOrder = priceOrder;
        this.orderNumber = orderNumber;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(String priceOrder) {
        this.priceOrder = priceOrder;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
