package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.entity.response.UserResponse;
import com.rayandahmena.project_3.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MeController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get user info")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Get user info with success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UserResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "401", description = "Error", content = @Content
            )
    })
    @RequestMapping(value="/auth/me", method = RequestMethod.GET)
    public UserResponse me(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        return new UserResponse(user);
    }
}
