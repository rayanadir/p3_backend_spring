package com.rayandahmena.project_3.entity.response;

/**
 * Message response class
 */
public class MessageResponse {

    private String message;

    public MessageResponse(String res){
        this.message = res;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
