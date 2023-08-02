package com.rayandahmena.project_3.repository;

import com.rayandahmena.project_3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
