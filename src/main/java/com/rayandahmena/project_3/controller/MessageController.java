package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.dto.MessageDTO;
import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.entity.request.NewMessageRequest;
import com.rayandahmena.project_3.entity.response.MessageResponse;
import com.rayandahmena.project_3.service.MessageService;
import com.rayandahmena.project_3.service.RentalService;
import com.rayandahmena.project_3.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("api")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Operation(summary = "Send message")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Message successfully sent",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MessageResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400", description = "Message not sent", content = @Content
            ),
            @ApiResponse(
                    responseCode = "401", description = "Message not sent", content = @Content
            )
    })
    @RequestMapping(value="/messages", method = RequestMethod.POST)
    public HashMap<String, String> sendMessage(@RequestBody NewMessageRequest newMessageReq){
        /*String message = newMessageReq.getMessage();
        int rental_id = rental.getId();
        int user_id= user.getId();
        MessageDTO messageDTO = new MessageDTO(rental_id, user_id, message);*/
        return messageService.newMessage(newMessageReq);
    }
}
