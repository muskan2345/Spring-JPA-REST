package com.example.Employee.demo.Employee.Dto;

import com.example.Employee.demo.Employee.Model.WorkExperiences;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto implements Serializable {


    private long id;
    private String title;
    private String description;
    private List<WorkExperiences> workExperiences;

}
