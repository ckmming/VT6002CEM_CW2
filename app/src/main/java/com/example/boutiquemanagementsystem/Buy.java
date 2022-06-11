package com.example.boutiquemanagementsystem;

public class Buy {

    int imagePath;
    int price;
    int total;

    //constructor
    public Buy(int imagePath, int price) {
        this.imagePath = imagePath;
        this.price = price;
    }

    //getter setter

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
