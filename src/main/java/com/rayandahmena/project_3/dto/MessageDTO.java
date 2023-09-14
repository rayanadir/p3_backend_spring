package com.rayandahmena.project_3.dto;

import java.sql.Timestamp;

/**
 * MessageDTO class
 */
public class MessageDTO {
    private int id;

    private int rental_id;

    private int user_id;

    private String message;

    private Timestamp created_at;

    private Timestamp updated_at;

    public MessageDTO(int rentalId,int userId,String message){
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
