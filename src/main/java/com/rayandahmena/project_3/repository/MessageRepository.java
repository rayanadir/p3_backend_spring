package com.rayandahmena.project_3.repository;

import com.rayandahmena.project_3.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {}
