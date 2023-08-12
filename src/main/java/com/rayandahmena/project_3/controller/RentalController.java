package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.service.RentalService;
import com.rayandahmena.project_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private UserService userService;


}
