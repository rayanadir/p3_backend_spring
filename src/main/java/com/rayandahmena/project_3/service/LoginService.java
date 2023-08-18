package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.dto.LoginDTO;
import com.rayandahmena.project_3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginService {

    @Autowired
    UserService userService;

    @Autowired
    JwtGeneratorService jwtGeneratorService;

    @Autowired
    AuthenticationManager authenticationManager;

    public HashMap<String,String> login(LoginDTO dto){
        String email= dto.getEmail();
        String password = dto.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        User user = userService.findByEmail(email);
        String token = jwtGeneratorService.generateToken(user);
        HashMap<String,String> res = new HashMap<>();
        if(token!=""){
            res.put("token",token);
        }else if(token==null || token==""){
            res.put("message","error");
        }
        return res;
    }
}
