package com.example.Employee.demo.Employee.Repository;

import com.example.Employee.demo.Employee.Model.Employee;
import com.example.Employee.demo.Employee.Model.EmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


   // public Employee findByEmail(String email);

    boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);

}
