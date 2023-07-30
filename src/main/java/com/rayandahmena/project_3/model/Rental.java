package com.rayandahmena.project_3.model;

import javax.persistence.*;
@Entity
@Table(name="RENTALS")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false, unique = true, length = 255)
    private String name;

    @Column(name = "surface")
    private Number surface;

    @Column(name = "price")
    private Number price;

    @Column(name="picture", length = 255)
    private String picture;

    @Column(name="description", length = 2000)
    private String description;

    @Column(name="owner_id", nullable = false)
    private int owner_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getSurface() {
        return surface;
    }

    public void setSurface(Number surface) {
        this.surface = surface;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
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

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
}
