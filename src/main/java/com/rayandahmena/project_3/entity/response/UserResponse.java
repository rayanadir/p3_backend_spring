package com.rayandahmena.project_3.entity.response;

import com.rayandahmena.project_3.entity.User;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UserResponse {
    private int id;

    private String name;

    private String email;

    private Timestamp created_at;

    private Timestamp updated_at;

    public UserResponse(){

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at() { return new SimpleDateFormat("yyyy/MM/dd").format(created_at) ; }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return new SimpleDateFormat("yyyy/MM/dd").format(updated_at);
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public UserResponse(User user){
        super();
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.created_at = user.getCreated_at();
        this.updated_at = user.getUpdated_at();
    }
}
