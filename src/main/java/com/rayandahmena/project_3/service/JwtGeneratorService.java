package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.interfaces.JwtGeneratorInterface;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import io.jsonwebtoken.Jwts;

import static com.rayandahmena.project_3.constants.Constants.EXPIRATION_TIME;
import static com.rayandahmena.project_3.constants.Constants.SECRET;


@Service
public class JwtGeneratorService implements JwtGeneratorInterface {
    @Override
    public String generateToken(User user){
        return Jwts.builder().setSubject(user.getEmail()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }

    public Claims getClaims(String token){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }
}
