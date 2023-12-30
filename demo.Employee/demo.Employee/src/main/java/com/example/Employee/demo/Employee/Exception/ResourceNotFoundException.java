package com.example.Employee.demo.Employee.Exception;


import com.example.Employee.demo.Employee.Model.EmployeeResponse;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data

public class ResourceNotFoundException extends RuntimeException{



    private String errorCode;
    public ResourceNotFoundException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }




}
