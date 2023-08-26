package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.entity.request.NewRentalRequest;
import com.rayandahmena.project_3.repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.rayandahmena.project_3.constants.Constants.BASE_URL;


@Service
public class RentalService {

    @Autowired
    private RentalsRepository rentalsRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    public Rental getRental(int id){
        return rentalsRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Error ! Rental not found : " + id)
        );
    }

    public List<Rental> getAllRentals(){
        return rentalsRepository.findAll();
    }

    public HashMap<String,String> createRental(NewRentalRequest rentalReq, int ownerId) throws IOException {
        String pictureName = imageService.loadImage(rentalReq.getPicture());
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String picture = baseUrl + '/' + pictureName;
        Rental rental = new Rental();
        rental.setName(rentalReq.getName());
        rental.setSurface(rentalReq.getSurface());
        rental.setPrice(rentalReq.getPrice());
        rental.setPicture(picture);
        rental.setDescription(rentalReq.getDescription());
        rental.setOwner_id(ownerId);
        rental.setCreated_at(new Timestamp(System.currentTimeMillis()));
        rental.setUpdated_at(new Timestamp(System.currentTimeMillis()));

        rentalsRepository.save(rental);
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Rental created !");
        return response;
    }

    public HashMap<String, String> updateRental(int id,NewRentalRequest newRentalReq){
        Rental rental = getRental(id);
        int ownerId = rental.getOwner_id();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        int userId = user.getId();
        // if userId and ownerId are different, forbid request
        if(!Objects.equals(ownerId,userId)){
            return new HashMap<>();
        }

        rental.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        rental.setPrice(newRentalReq.getPrice());
        rental.setDescription(newRentalReq.getDescription());
        rental.setName(newRentalReq.getName());
        rental.setSurface(newRentalReq.getSurface());
        rental.setId(rental.getId());
        rental.setCreated_at(rental.getCreated_at());
        rental.setOwner_id(ownerId);
        rental.setPicture(rental.getPicture());

        rentalsRepository.save(rental);

        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Rental updated !");
        return response;
    }
}
