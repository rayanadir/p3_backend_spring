package com.rayandahmena.project_3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rayandahmena.project_3.dto.RentalDTO;
import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.entity.request.NewRentalRequest;
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

    @RequestMapping(value = "/rentals", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,String>> createRental(NewRentalRequest newRentalReq) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        int ownerId = user.getId();
        return ResponseEntity.ok(rentalService.createRental(newRentalReq, ownerId));
    }

    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.PUT)
    public ResponseEntity<HashMap<String,String>> updateRental(@PathVariable int id, NewRentalRequest newRentalReq){
        return ResponseEntity.ok(rentalService.updateRental(id,newRentalReq));
    }
}
