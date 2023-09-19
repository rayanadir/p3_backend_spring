package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.dto.RegisterDTO;
import com.rayandahmena.project_3.dto.TokenDTO;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.HashMap;

/**
 * Class that handles Register feature
 */
@Service
public class RegisterService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtGeneratorService jwtGeneratorService;

    @Autowired
    private UserRepository userRepository;

    /**
     * Register method, returns user registered token
     * @param dto Object that contains register credentials
     * @return String (token)
     */
    public String register(RegisterDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setCreated_at(new Timestamp(System.currentTimeMillis()));
        user.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        if(userService.isEmailAvailable(user)){
            userService.createNewUser(user);
            return jwtGeneratorService.generateToken(user);
        }
        return null;
    }
}
