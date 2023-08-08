package com.rayandahmena.project_3.interfaces;

import com.rayandahmena.project_3.entity.User;

public interface JwtGeneratorInterface {
    String generateToken(User user);
}
