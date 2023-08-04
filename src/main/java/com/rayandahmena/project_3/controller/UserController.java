package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {

    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable int id){
        return userService.getUser(id);
    }
}
