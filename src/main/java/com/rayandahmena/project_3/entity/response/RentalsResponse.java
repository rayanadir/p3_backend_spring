package com.rayandahmena.project_3.entity.response;

import com.rayandahmena.project_3.entity.Rental;

import java.util.List;

public class RentalsResponse {

    private List<Rental> rentals;

    public RentalsResponse(List<Rental> rentalList){
        this.rentals=rentalList;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
}
