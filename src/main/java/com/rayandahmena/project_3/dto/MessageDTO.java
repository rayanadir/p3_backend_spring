package com.rayandahmena.project_3.dto;

import java.sql.Timestamp;

public class MessageDTO {
    private int id;

    private int rental_id;

    private int user_id;

    private String message;

    private Timestamp created_at;

    private Timestamp updated_at;

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
