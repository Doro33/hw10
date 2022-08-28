package online_shop.entity.order;

import online_shop.entity.products.Product;

import java.util.ArrayList;

public class Item {
    private int id;
    private int orderId;
    private String kind;
    private int productId;
    private int number;
    private float unitPrice;
    private float retailPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if(number>0)
            this.number = number;
        else throw new NumberFormatException();
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(float retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", kind='" + kind + '\'' +
                ", productId=" + productId +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                ", retailPrice=" + retailPrice +
                '}';
    }
}