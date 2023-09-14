package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.dto.RentalDTO;
import com.rayandahmena.project_3.entity.request.NewRentalRequest;
import com.rayandahmena.project_3.entity.response.RentalResponse;
import com.rayandahmena.project_3.entity.response.RentalsResponse;
import com.rayandahmena.project_3.service.RentalService;
import com.rayandahmena.project_3.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Class that handles "Rentals" controller
 */
@RestController
@RequestMapping("api")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private UserService userService;


    /**
     * Get a single rental by id
     * @param id id of the rental
     * @return RentalDTO
     */
    @Operation(summary = "Get a single rental data by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "OK",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RentalDTO.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(examples = @ExampleObject(value=""))
                    }
            )
    })
    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.GET)
    public RentalDTO getRental(@PathVariable int id){
        return new RentalDTO(rentalService.getRental(id));
    }

    /**
     * Get all rentals
     * @return RentalsResponse
     */
    @Operation(summary = "Get all rentals")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "OK",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RentalsResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(
                                    examples = @ExampleObject(value="")
                            )
                    }
            )
    })
    @RequestMapping(value = "/rentals", method = RequestMethod.GET)
    public RentalsResponse getAllRentals(){
        return new RentalsResponse(rentalService.getAllRentals());
    }

    /**
     * Create a rental
     * @param newRentalReq Object that contains rental request attributes
     * @return RentalResponse
     * @throws IOException
     */
    @Operation(summary = "Create a rental")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Created",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RentalResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(
                                    examples = @ExampleObject(value="")
                            )
                    }
            )
    })
    @RequestMapping(value = "/rentals", method = RequestMethod.POST)
    public RentalResponse createRental(NewRentalRequest newRentalReq) throws IOException {
        return rentalService.createRental(newRentalReq);
    }

    /**
     * Update a rental by its id
     * @param id id of the rental to update
     * @param newRentalReq Object that contains rental request attributes
     * @return RentalResponse
     */
    @Operation(summary = "Update a rental by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "OK",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RentalResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(
                                    examples = @ExampleObject(value="")
                            )
                    }
            )
    })
    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.PUT)
    public RentalResponse updateRental(@PathVariable int id, NewRentalRequest newRentalReq){
        return rentalService.updateRental(id,newRentalReq);
    }
}
