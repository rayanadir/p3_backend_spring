package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.entity.Message;
import com.rayandahmena.project_3.service.MessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("api")
public class MessageController {

    private MessageService messageService;

    @RequestMapping(value="/messages", method = RequestMethod.POST)
    public String sendMessage(Message messageReq){
        Message newMessage = new Message();
        newMessage.setMessage(messageReq.getMessage());
        newMessage.setRental_id(messageReq.getRental_id());
        newMessage.setUser_id(messageReq.getUser_id());
        newMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));

        Message message = messageService.saveMessage(newMessage);
        if(message != null){
            return "Message send with success";
        }
        return "Error : message not sent";
    }
}
