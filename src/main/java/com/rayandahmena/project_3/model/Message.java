package com.rayandahmena.project_3.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="MESSAGES")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="rental_id")
    private int rental_id;

    @Column(name="user_id")
    private int user_id;

    @Column(name="message", length = 2000)
    private String message;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreated_at() { return created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getUpdated_at() { return updated_at; }

    public void setUpdated_at(Timestamp updated_at) { this.updated_at = updated_at; }

}
