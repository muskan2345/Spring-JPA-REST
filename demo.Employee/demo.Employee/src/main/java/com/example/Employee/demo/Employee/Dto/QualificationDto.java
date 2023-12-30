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
public class QualificationDto implements Serializable {

    private String qualificationName;
    private double percentage;
    private String fromDate;

    private String toDate;
    private List<WorkExperiences> workExperiences;
}
