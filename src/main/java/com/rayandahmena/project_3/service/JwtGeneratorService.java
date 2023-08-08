package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.interfaces.JwtGeneratorInterface;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import io.jsonwebtoken.Jwts;

@Service
public class JwtGeneratorService implements JwtGeneratorInterface {
    @Override
    public String generateToken(User user){
        return Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret").compact();
    }
}
