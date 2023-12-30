package com.example.Employee.demo.Employee.Model;


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
@Entity

public class WorkExperiences implements  Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long workExperience_id;
    private String companyName;

    private String fromDate;

    private String toDate;

    private String address;

    @OneToMany(mappedBy = "workExperiences", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Qualification> qualification;

    @OneToMany(mappedBy = "workExperiences", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Project> project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
