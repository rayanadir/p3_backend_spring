package com.rayandahmena.project_3.dto;


import com.rayandahmena.project_3.entity.Rental;

import java.sql.Timestamp;

public class RentalDTO {

    private int id;

    private String name;

    private int surface;

    private int price;

    private String picture;

    private String description;

    private int owner_id;

    private Timestamp created_at;

    private Timestamp updated_at;

    public RentalDTO(Rental rental){
        this.id = rental.getId();
        this.name = rental.getName();
        this.surface = rental.getSurface();
        this.price = rental.getPrice();
        this.description = rental.getDescription();
        this.owner_id = rental.getOwner_id();
        this.created_at = rental.getCreated_at();
        this.updated_at = rental.getUpdated_at();
        this.picture = rental.getPicture();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwner_id() { return owner_id; }

    public void setOwner_id(int owner_id) { this.owner_id = owner_id; }

    public Timestamp getCreated_at() { return created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getUpdated_at() { return updated_at; }

    public void setUpdated_at(Timestamp updated_at) { this.updated_at = updated_at; }
}
