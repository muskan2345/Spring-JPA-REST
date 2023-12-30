package com.example.Employee.demo.Employee.Dto;

import com.example.Employee.demo.Employee.Model.Employee;
import com.example.Employee.demo.Employee.Model.Project;
import com.example.Employee.demo.Employee.Model.Qualification;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto implements Serializable {

    private long workExperience_id;
    private String companyName;
    private String fromDate;
    private String toDate;
    private String address;
    private Qualification qualification;
    private Project project;
  //  private Employee employee;

}
