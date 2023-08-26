package com.rayandahmena.project_3.entity;

import com.rayandahmena.project_3.entity.request.NewRentalRequest;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="RENTALS")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false, unique = true, length = 255)
    private String name;

    @Column(name = "surface")
    private int surface;

    @Column(name = "price")
    private int price;

    @Column(name="picture", length = 255)
    private String picture;

    @Column(name="description", length = 2000)
    private String description;

    @Column(name="owner_id", nullable = false)
    private int owner_id;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;


    /*public Rental(NewRentalRequest rentalRequest, int owner_id){
        this.name = rentalRequest.getName();
        this.surface = rentalRequest.getSurface();
        this.price = rentalRequest.getPrice();
        this.picture = rentalRequest.getPicture();
        this.description = rentalRequest.getDescription();
        this.owner_id = owner_id;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public int getPrice() {
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

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public Timestamp getCreated_at() { return created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getUpdated_at() { return updated_at; }

    public void setUpdated_at(Timestamp updated_at) { this.updated_at = updated_at; }
}
