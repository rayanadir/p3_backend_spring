package com.rayandahmena.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(path = "auth")
public class RegisterController {
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(){
        
    }
}
