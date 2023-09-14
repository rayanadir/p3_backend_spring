package com.rayandahmena.project_3.entity.response;

/**
 * Token response class
 */
public class TokenResponse {
    private String token;

    public TokenResponse(String token){
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
