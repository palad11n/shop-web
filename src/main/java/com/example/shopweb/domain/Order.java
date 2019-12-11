package com.example.shopweb.domain;

public class Order {
    private int id = -1;
    private String name;
    private int price;
    private boolean status = false;

    public Order(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Order(String name, int price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
