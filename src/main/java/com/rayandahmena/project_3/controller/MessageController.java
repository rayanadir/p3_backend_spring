package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.dto.MessageDTO;
import com.rayandahmena.project_3.entity.Message;
import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.entity.request.NewMessageRequest;
import com.rayandahmena.project_3.service.MessageService;
import com.rayandahmena.project_3.service.RentalService;
import com.rayandahmena.project_3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("api")
public class MessageController {

    private MessageService messageService;

    private UserService userService;

    private RentalService rentalService;

    @RequestMapping(value="/messages", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,String>> sendMessage(NewMessageRequest newMessageReq, Authentication auth){
        User user = userService.findById(newMessageReq.getUser_id());
        // If different user id, forbid authorization
        if(!Objects.equals(userService.findByEmail(auth.getName()).getId(), user.getId())){
            return new ResponseEntity<>(new HashMap<>(), HttpStatus.UNAUTHORIZED);
        }
        Rental rental = rentalService.getRental(newMessageReq.getRental_id());
        MessageDTO messageDTO = new MessageDTO(newMessageReq.getMessage(), user.getId(), rental.getId());
        messageService.newMessage(messageDTO);
        HashMap<String,String> response = new HashMap<String,String>();
        response.put("message", "Message sent with success");
        return ResponseEntity.ok(response);
    }
}
