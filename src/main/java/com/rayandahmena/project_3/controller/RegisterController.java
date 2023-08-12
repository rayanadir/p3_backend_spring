package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.dto.RegisterDTO;
import com.rayandahmena.project_3.dto.TokenDTO;
import com.rayandahmena.project_3.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/auth")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<TokenDTO> register(@RequestBody RegisterDTO dto){
        TokenDTO token = new TokenDTO();
        token.setToken(registerService.register(dto));
        return ResponseEntity.ok(token);
    }
}
