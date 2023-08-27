package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.dto.MessageDTO;
import com.rayandahmena.project_3.entity.Message;
import com.rayandahmena.project_3.entity.Rental;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.entity.request.NewMessageRequest;
import com.rayandahmena.project_3.entity.response.MessageResponse;
import com.rayandahmena.project_3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Objects;


@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public HashMap<String, String> newMessage(NewMessageRequest messageReq){
        Message message = new Message();
        message.setMessage(messageReq.getMessage());
        message.setUser_id(messageReq.getUser_id());
        message.setRental_id(messageReq.getRental_id());
        message.setCreated_at(new Timestamp(System.currentTimeMillis()));
        message.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        messageRepository.save(message);
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Message sent with success");
        MessageResponse res = new MessageResponse(response);
        return response;
    }
}
