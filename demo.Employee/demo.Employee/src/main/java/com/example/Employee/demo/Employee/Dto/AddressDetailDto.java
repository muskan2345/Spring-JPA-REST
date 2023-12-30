package com.example.Employee.demo.Employee.Dto;

import com.example.Employee.demo.Employee.Model.Employee;
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
public class AddressDetailDto implements Serializable {

        private int hno;

        private String street;

        private String city;

        private String state;
     //   private Employee employee;

}
