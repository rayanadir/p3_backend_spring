package com.rayandahmena.project_3.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Image entity class
 */
@Data
@Entity
@Table(name="LOCATION")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
