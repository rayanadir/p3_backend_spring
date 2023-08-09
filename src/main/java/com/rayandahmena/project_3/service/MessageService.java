package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.entity.Message;
import com.rayandahmena.project_3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message){
       return messageRepository.save(message);
    }
}
