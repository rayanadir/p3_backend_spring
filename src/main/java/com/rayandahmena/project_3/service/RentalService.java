package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.entity.Image;
import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.entity.request.NewRentalRequest;
import com.rayandahmena.project_3.entity.response.RentalResponse;
import com.rayandahmena.project_3.repository.RentalsRepository;
import com.rayandahmena.project_3.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


/**
 * Class that handles rental methods
 */
@Service
public class RentalService {

    @Autowired
    private RentalsRepository rentalsRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    /**
     * Get a single rental
     * @param id id of the rental
     * @return Rental
     */
    public Rental getRental(int id){
        return rentalsRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Error ! Rental not found : " + id)
        );
    }

    /**
     * Get all rentals
     * @return List of rentals
     */
    public List<Rental> getAllRentals(){
        return rentalsRepository.findAll();
    }

    /**
     * Create a rental
     * @param rentalReq Object that contains rental request attributes
     * @return RentalResponse
     * @throws IOException
     */
    public RentalResponse createRental(NewRentalRequest rentalReq) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        int ownerId = user.getId();

        String pictureName = imageService.loadImage(rentalReq.getPicture());
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String picture = baseUrl + "/" + pictureName;
        Image image = new Image();

        Rental rental = new Rental();
        rental.setName(rentalReq.getName());
        rental.setSurface(rentalReq.getSurface());
        rental.setPrice(rentalReq.getPrice());
        rental.setPicture(picture);
        image.setUrl(picture);
        rental.setDescription(rentalReq.getDescription());
        rental.setOwner_id(ownerId);
        rental.setCreated_at(new Timestamp(System.currentTimeMillis()));
        rental.setUpdated_at(new Timestamp(System.currentTimeMillis()));

        if(rental!=null){
            rentalsRepository.save(rental);
            imageRepository.save(image);
            return new RentalResponse("Rental created !");
        }
        return null;

    }

    /**
     * Update a rental by its id
     * @param id id of the rental to update
     * @param newRentalReq Object that contains rental request attributes
     * @return RentalResponse
     */
    public RentalResponse updateRental(int id,NewRentalRequest newRentalReq){
        Rental rental = getRental(id);
        int ownerId = rental.getOwner_id();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        int userId = user.getId();
        // if userId and ownerId are different, forbid request
        if(!Objects.equals(ownerId,userId)){
            return new RentalResponse("");
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

        if(rental!=null){
            rentalsRepository.save(rental);
            return new RentalResponse("Rental updated !");
        }
        return null;

    }
}
