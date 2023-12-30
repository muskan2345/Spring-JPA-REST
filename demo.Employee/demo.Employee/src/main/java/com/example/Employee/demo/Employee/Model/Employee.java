package com.example.Employee.demo.Employee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private int employee_id;
    private String name;

    @Column(unique=true)
    private String email;
    private int age;
    private String phoneNo;
    private String gender;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade={ CascadeType.MERGE})
    private Set<AddressDetails> addressDetails ;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<WorkExperiences> workExperiences;

}
