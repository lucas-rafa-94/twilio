package com.revobank.backend.fitbank.model.response;

public class ResponseModel {
    public long status;
    public String message;

    public ResponseModel(long status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseModel() {
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
