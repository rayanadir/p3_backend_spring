package com.rayandahmena.project_3.entity.response;

import com.rayandahmena.project_3.entity.User;

import java.sql.Timestamp;

public class UserResponse {
    private int id;

    private String name;

    private String email;

    private Timestamp created_at;

    private  Timestamp updated_at;

    public UserResponse(User user){
        super();
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.created_at = user.getCreated_at();
        this.updated_at = user.getUpdated_at();
    }
}
