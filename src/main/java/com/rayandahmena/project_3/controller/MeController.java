package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MeController {

    private UserService userService;

    @RequestMapping(value="/auth/me", method = RequestMethod.GET)
    public UserDetails me(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.loadUserByUsername(authentication.getName());
    }
}
