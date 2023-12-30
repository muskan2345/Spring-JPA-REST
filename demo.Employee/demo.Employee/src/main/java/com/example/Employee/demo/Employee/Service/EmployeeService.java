package com.example.Employee.demo.Employee.Service;

import com.example.Employee.demo.Employee.Dto.EmployeeDto;
import com.example.Employee.demo.Employee.Model.Employee;

import java.util.*;

public interface EmployeeService
{

    public EmployeeDto createEmployee(EmployeeDto employeeDto);


    public EmployeeDto update(Long id, EmployeeDto employeeDto);

    public void delete(Long id);

    public List<Employee> getAll();


//    Employee isEmployeeIdDuplicate(String email);

    Optional<Employee> findByEmail(String email);
    public boolean exist(String email);


   // String employeeIdDuplicate(String email);

    public EmployeeDto getById(Long id);
}
