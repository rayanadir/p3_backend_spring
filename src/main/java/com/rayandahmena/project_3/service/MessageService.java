package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.dto.MessageDTO;
import com.rayandahmena.project_3.entity.Message;
import com.rayandahmena.project_3.repository.MessageRepository;

import java.sql.Timestamp;

public class MessageService {

    private MessageRepository messageRepository;

    public Message saveMessage(Message message){
       return messageRepository.save(message);
    }
}
