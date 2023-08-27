package com.rayandahmena.project_3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rayandahmena.project_3.dto.RentalDTO;
import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.entity.request.NewRentalRequest;
import com.rayandahmena.project_3.entity.response.RentalResponse;
import com.rayandahmena.project_3.entity.response.RentalsResponse;
import com.rayandahmena.project_3.service.RentalService;
import com.rayandahmena.project_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.GET)
    public RentalDTO getRental(@PathVariable int id){
        return new RentalDTO(rentalService.getRental(id));
    }

    @RequestMapping(value = "/rentals", method = RequestMethod.GET)
    public RentalsResponse getAllRentals(){
        return new RentalsResponse(rentalService.getAllRentals());
    }

    @RequestMapping(value = "/rentals", method = RequestMethod.POST)
    public RentalResponse createRental(NewRentalRequest newRentalReq) throws IOException {
        return rentalService.createRental(newRentalReq);
    }

    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.PUT)
    public RentalResponse updateRental(@PathVariable int id, NewRentalRequest newRentalReq){
        return rentalService.updateRental(id,newRentalReq);
    }
}
