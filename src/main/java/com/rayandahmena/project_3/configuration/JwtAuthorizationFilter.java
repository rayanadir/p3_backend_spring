package com.rayandahmena.project_3.configuration;

import com.rayandahmena.project_3.service.JwtGeneratorService;
import com.rayandahmena.project_3.service.UserService;
import io.jsonwebtoken.Claims;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

import static com.rayandahmena.project_3.constants.Constants.HEADER_STRING;
import static com.rayandahmena.project_3.constants.Constants.TOKEN_PREFIX;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    JwtGeneratorService jwtGeneratorService;

    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        if(SecurityContextHolder.getContext().getAuthentication() == null){
            String authorization = req.getHeader(HEADER_STRING);
            if(authorization != null && authorization.startsWith(TOKEN_PREFIX)){
                // Get token by removing "Bearer "
                String token = authorization.substring(7);
                // Get token properties
                Claims claims = jwtGeneratorService.getClaims(token);
                if(claims.getExpiration().after(new Date())){
                    String name = claims.getSubject();
                    UserDetails userDetails = userService.loadUserByUsername(name);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(req,res);
    }
}
