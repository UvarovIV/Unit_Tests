package com.example;

public class Pizza {

    private String title;
    private String size;
    private String price;

    public Pizza() {}

    public Pizza(String title, String size, String price) {
        this.title = title;
        this.size = size;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    } 

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
