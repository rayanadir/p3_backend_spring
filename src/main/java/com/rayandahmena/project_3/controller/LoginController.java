package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.dto.LoginDTO;
import com.rayandahmena.project_3.entity.response.TokenResponse;
import com.rayandahmena.project_3.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/api/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Operation(summary = "Login user by email & password")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Successful login",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TokenResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "401", description = "Login failed", content = @Content
            )
    })
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public TokenResponse login(@RequestBody LoginDTO dto){
        return new TokenResponse(loginService.login(dto));
    }
}
