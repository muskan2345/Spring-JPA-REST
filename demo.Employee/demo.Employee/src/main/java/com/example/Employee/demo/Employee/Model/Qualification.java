package com.example.Employee.demo.Employee.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Qualification implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String qualificationName;

    private double percentage;

    private String fromDate;

    private String toDate;
    @ManyToOne
    @JoinColumn(name = "workExperience_id")
    private WorkExperiences workExperiences;


}
