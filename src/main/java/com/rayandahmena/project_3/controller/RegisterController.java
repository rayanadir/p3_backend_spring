package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.dto.RegisterDTO;

import com.rayandahmena.project_3.entity.response.TokenResponse;
import com.rayandahmena.project_3.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "api/auth")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @Operation(summary = "Register user by name, email & password")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Successful register",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TokenResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400", description = "Register failed", content = @Content
            )
    })
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public TokenResponse register(@RequestBody RegisterDTO dto){
        return new TokenResponse(registerService.register(dto));
    }
}
