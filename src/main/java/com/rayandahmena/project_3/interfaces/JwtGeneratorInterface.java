package com.rayandahmena.project_3.interfaces;

import com.rayandahmena.project_3.entity.User;

import java.util.Map;

public interface JwtGeneratorInterface {
    String generateToken(User user);
}
