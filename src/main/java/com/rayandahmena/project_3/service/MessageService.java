package com.rayandahmena.project_3.service;


import com.rayandahmena.project_3.entity.Message;

import com.rayandahmena.project_3.entity.request.NewMessageRequest;

import com.rayandahmena.project_3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.sql.Timestamp;


/**
 * Class that handles messages
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Send a message
     * @param messageReq takes message attributes as parameters
     * @return saves message into messageRepository
     */
    public Message newMessage(NewMessageRequest messageReq){
        Message message = new Message();
        message.setMessage(messageReq.getMessage());
        message.setUser_id(messageReq.getUser_id());
        message.setRental_id(messageReq.getRental_id());
        message.setCreated_at(new Timestamp(System.currentTimeMillis()));
        message.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        return messageRepository.save(message);
    }
}
