package com.sushimayo.models;

public class ResponseModel {
    private boolean status;

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
