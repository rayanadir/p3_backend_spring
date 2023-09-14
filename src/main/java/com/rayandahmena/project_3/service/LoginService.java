package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.dto.LoginDTO;
import com.rayandahmena.project_3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Class that handles Login feature
 */
@Service
public class LoginService {

    @Autowired
    UserService userService;

    @Autowired
    JwtGeneratorService jwtGeneratorService;

    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * Login method, returns user logged token
     * @param dto Object that contains login credentials
     * @return String (token)
     */
    public String login(LoginDTO dto){
        String email= dto.getEmail();
        String password = dto.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        User user = userService.findByEmail(email);
        String token = jwtGeneratorService.generateToken(user);
        if(token!=""){
            return token;
        }
        return null;
    }
}
