package com.example.models;

public class Items {

    String name;
    String data;
    int image;
    int cost;

    public Items(String name, String data, int image, int cost) {
        this.name = name;
        this.data = data;
        this.image = image;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
