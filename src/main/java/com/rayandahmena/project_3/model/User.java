package com.rayandahmena.project_3.model;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="email" ,nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "name", nullable = false,length = 255)
    private String name;

    @Column(name="password",nullable = false, length = 255)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
