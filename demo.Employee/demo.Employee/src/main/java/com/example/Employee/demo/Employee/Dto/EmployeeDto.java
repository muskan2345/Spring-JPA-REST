package com.example.Employee.demo.Employee.Dto;

import com.example.Employee.demo.Employee.Model.AddressDetails;
import com.example.Employee.demo.Employee.Model.Project;
import com.example.Employee.demo.Employee.Model.Qualification;
import com.example.Employee.demo.Employee.Model.WorkExperiences;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto implements Serializable
{
    private int employee_id;
    private String name;

    private String email;
    private int age;

    private String gender;

    private String phoneNo;

    private Set<AddressDetails> addressDetails;

    private List<WorkExperiences> workExperiences;

}
