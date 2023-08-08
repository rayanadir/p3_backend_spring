package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.dto.RegisterDTO;
import com.rayandahmena.project_3.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RegisterService {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtGeneratorService jwtGeneratorService;

    public String register(RegisterDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userService.createNewUser(user);

        return jwtGeneratorService.generateToken(user);
    }
}
