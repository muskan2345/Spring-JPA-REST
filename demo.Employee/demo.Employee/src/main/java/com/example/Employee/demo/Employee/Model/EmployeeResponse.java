package com.example.Employee.demo.Employee.Model;

public class EmployeeResponse
{

    private String message;
//    private String email;
    private boolean success;

    private long id;

    public EmployeeResponse(String message, boolean success) {
        this.message = message;

        this.success = success;
    }

    public EmployeeResponse(String message, boolean success,long id) {
        this.message = message;
        this.id=id;

        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


}
