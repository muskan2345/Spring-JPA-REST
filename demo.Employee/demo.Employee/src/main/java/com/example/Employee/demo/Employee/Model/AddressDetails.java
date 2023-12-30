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
public class AddressDetails implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String hno;

    private String street;

    private String city;

    private String state;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
