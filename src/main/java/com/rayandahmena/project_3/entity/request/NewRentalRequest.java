package com.rayandahmena.project_3.entity.request;

import org.springframework.web.multipart.MultipartFile;

public class NewRentalRequest {
    private String name;

    private int surface;

    private int price;

    private MultipartFile picture;

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

    public void setSurface(int surface) { this.surface = surface; }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){ this.price = price; }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description= description; }
}
