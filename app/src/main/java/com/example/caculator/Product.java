package com.example.caculator;

import java.io.Serializable;

public class Product   implements Serializable {
    String name;
    String urlImg;
    String price;

    public Product() {
    }

    public Product(String name, String urlImg, String price) {
        this.name = name;
        this.urlImg = urlImg;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", price=" + price +
                '}';
    }
}
