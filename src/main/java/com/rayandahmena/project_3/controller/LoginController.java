package com.rayandahmena.project_3.controller;

import com.rayandahmena.project_3.dto.LoginDTO;
import com.rayandahmena.project_3.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody LoginDTO dto){
        return ResponseEntity.ok(loginService.login(dto));
    }
}
