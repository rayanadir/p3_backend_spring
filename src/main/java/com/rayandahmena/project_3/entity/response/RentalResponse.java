package com.rayandahmena.project_3.entity.response;

/**
 * Rental response class
 */
public class RentalResponse {
    private String message;

    public RentalResponse(String res){
        this.message=res;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
