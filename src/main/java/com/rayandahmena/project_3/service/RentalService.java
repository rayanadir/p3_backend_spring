package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.entity.request.NewRentalRequest;
import com.rayandahmena.project_3.repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class RentalService {

    @Autowired
    private RentalsRepository rentalsRepository;

    public Rental getRental(int id){
        return rentalsRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Error ! Rental not found : " + id)
        );
    }

    public List<Rental> getAllRentals(){
        return rentalsRepository.findAll();
    }

    public HashMap<String,String> createRental(NewRentalRequest rentalReq, int ownerId){
        Rental rental = new Rental(rentalReq, ownerId);
        rentalsRepository.save(rental);
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Rental created !");
        return response;
    }

    public HashMap<String, String> updateRental(Rental rental){
        rentalsRepository.save(rental);
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Rental updated !");
        return response;
    }
}
