package com.rayandahmena.project_3.dto;

import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.entity.User;

import java.sql.Timestamp;

public class MessageDTO {
    private int id;

    private int rental_id;

    private int user_id;

    private String message;

    private Timestamp created_at;

    private Timestamp updated_at;

    public MessageDTO(String message, int userId, int rentalId){
        this.message = message;
        this.user_id = userId;
        this.rental_id = rentalId;
    }

    public int getId() {
        return id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }
}
