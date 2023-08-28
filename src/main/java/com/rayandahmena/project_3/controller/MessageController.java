package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.entity.request.NewMessageRequest;
import com.rayandahmena.project_3.entity.response.MessageResponse;
import com.rayandahmena.project_3.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Operation(summary = "Send message")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "OK",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MessageResponse.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400", description = "Bad request",
                    content = { @Content(mediaType = "application/json",examples = @ExampleObject(value="{}")) }
            ),
            @ApiResponse(
                    responseCode = "401", description = "Unauthorized",
                    content = { @Content(examples = @ExampleObject(value="")) }
            )
    })
    @RequestMapping(value="/messages", method = RequestMethod.POST)
    public MessageResponse sendMessage(@RequestBody NewMessageRequest newMessageReq){
        messageService.newMessage(newMessageReq);
        return new MessageResponse("Message sent with success");
    }
}


