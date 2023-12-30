package com.example.Employee.demo.Employee.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message
{
    public Message(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private String message;
    private boolean success;
}
