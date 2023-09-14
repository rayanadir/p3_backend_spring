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


/**
 * Class that handles token
 */
@Service
public class JwtGeneratorService implements JwtGeneratorInterface {

    /**
     * Generates and returns a string token
     * @param user
     * @return String (token)
     */
    @Override
    public String generateToken(User user){
        return Jwts.builder().setSubject(user.getEmail()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }

    /**
     * Get token properties
     * @param token
     * @return Claims
     */
    public Claims getClaims(String token){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }
}
