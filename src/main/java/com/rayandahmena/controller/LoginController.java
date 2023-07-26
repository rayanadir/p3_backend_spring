package com.rayandahmena.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping(path="auth")
public class LoginController {
    
    @RolesAllowed({"OWNER","TENANT"})
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(){

    }
}
