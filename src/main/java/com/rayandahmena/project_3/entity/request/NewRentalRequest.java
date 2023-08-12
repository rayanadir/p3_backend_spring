package com.rayandahmena.project_3.entity.request;

public class NewRentalRequest {
    private String name;

    private int surface;

    private int price;

    private String picture;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSurface() {
        return surface;
    }

    public int getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }
}
