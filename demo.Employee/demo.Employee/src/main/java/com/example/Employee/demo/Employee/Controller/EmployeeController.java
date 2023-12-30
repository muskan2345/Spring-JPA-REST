package com.example.Employee.demo.Employee.Controller;


//import com.example.Employee.demo.Employee.Model.Message;
import com.example.Employee.demo.Employee.Dto.EmployeeDto;
import com.example.Employee.demo.Employee.Model.Employee;
import com.example.Employee.demo.Employee.Model.EmployeeResponse;
import com.example.Employee.demo.Employee.Repository.EmployeeRepository;
import com.example.Employee.demo.Employee.Service.EmployeeService;
import com.example.Employee.demo.Employee.Service.EmployeeServiceImplementation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

import java.util.*;
import org.json.simple.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController implements  Serializable{

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    private Logger logger = LoggerFactory.getLogger(EmployeeServiceImplementation.class);

    @PostMapping("create")
    public ResponseEntity<?>  create( @RequestBody EmployeeDto employeeDto){

         String email= employeeDto.getEmail();
         System.out.println("****************");
         System.out.println(email + "&***");

         // Check if the employee ID is a duplicate
         if (employeeService.exist(email)) {
             System.out.println("true");
             EmployeeResponse errorResponse = new EmployeeResponse("Employee ID is  duplicate", false);
             return ResponseEntity.ok(errorResponse);

         }
         else {
             EmployeeDto employee1 = employeeService.createEmployee(employeeDto);
             logger.info(employee1.getAddressDetails().toString());

             EmployeeResponse employeeResponse = new EmployeeResponse("employee created successfully", true);
             return ResponseEntity.ok(employee1);
         }

    }
    @GetMapping(path = "getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get() throws JsonProcessingException {

        List<Employee> all = employeeService.getAll();
        EmployeeResponse employeeResponse = new EmployeeResponse("All Employee are Listed", true);
       // ObjectMapper mapper = new ObjectMapper();
      return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PutMapping("update-employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto)
    {

        EmployeeDto update = employeeService.update(id, employeeDto);
        EmployeeResponse employeeResponse = new EmployeeResponse("employee updated successfully", true);

        return  ResponseEntity.ok(update);

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        employeeService.delete(id);
        EmployeeResponse employeeResponse = new EmployeeResponse("employee deleted successfully", true,id);
        return new ResponseEntity<>(employeeResponse,HttpStatus.OK);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id)
    {
        EmployeeDto byId = employeeService.getById(id);
        EmployeeResponse employeeResponse = new EmployeeResponse("Get Employee by  id", true);
        return new ResponseEntity<>(byId,HttpStatus.OK);


    }





}
