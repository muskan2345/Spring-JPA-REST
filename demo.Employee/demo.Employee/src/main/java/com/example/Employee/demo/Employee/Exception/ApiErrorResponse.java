package com.example.Employee.demo.Employee.Exception;

public class ApiErrorResponse
{

    private long code;
    private String message;

    public ApiErrorResponse(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public long getCode() {
        return code;
    }
}
