package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.dto.RegisterDTO;
import com.rayandahmena.project_3.dto.TokenDTO;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@Service
public class RegisterService {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtGeneratorService jwtGeneratorService;

    @Autowired
    UserRepository userRepository;

    public HashMap<String,String> register(RegisterDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        HashMap<String,String> res = new HashMap<>();
        if(userService.isEmailAvailable(user)){
            userService.createNewUser(user);
            res.put("token", jwtGeneratorService.generateToken(user));
        }
        return res;
    }
}
