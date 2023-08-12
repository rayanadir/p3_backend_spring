package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.entity.response.UserResponse;
import com.rayandahmena.project_3.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {

    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserResponse> getUser(@PathVariable int id){
        User user = userService.findById(id);
        return ResponseEntity.ok(new UserResponse(user));
    }
}
