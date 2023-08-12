package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.dto.RentalDTO;
import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.service.RentalService;
import com.rayandahmena.project_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.GET)
    public ResponseEntity<RentalDTO> getRental(@PathVariable int id){
        return ResponseEntity.ok(new RentalDTO(rentalService.getRental(id)));
    }

    @RequestMapping(value = "/rentals", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<RentalDTO>>> getAllRentals(){
        List<Rental> rentals = new ArrayList<>(rentalService.getAllRentals());
        Map<String, List<RentalDTO>> result = new HashMap<>();
        List<RentalDTO> rentalDTOList = rentals.stream().map(rental -> new RentalDTO(rental)).collect(Collectors.toList());
        result.put("rentals",rentalDTOList);
        return ResponseEntity.ok(result);
    }

}
