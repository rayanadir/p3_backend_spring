package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
