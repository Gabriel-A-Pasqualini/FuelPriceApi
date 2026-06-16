package com.fuelpriceapi.entity.health;

public class Health {

    private String status;
    private String message;

    public Health(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}