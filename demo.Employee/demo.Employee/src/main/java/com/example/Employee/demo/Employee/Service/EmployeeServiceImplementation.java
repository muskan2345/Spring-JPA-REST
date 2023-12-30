package com.example.Employee.demo.Employee.Service;

import com.example.Employee.demo.Employee.Dto.EmployeeDto;
import com.example.Employee.demo.Employee.Exception.ApiErrorResponse;
import com.example.Employee.demo.Employee.Exception.ApiExceptionalHandler;
import com.example.Employee.demo.Employee.Exception.ResourceNotFoundException;
import com.example.Employee.demo.Employee.Model.*;
import com.example.Employee.demo.Employee.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImplementation implements EmployeeService{
    
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper mapper;

    private Logger logger = LoggerFactory.getLogger(EmployeeServiceImplementation.class);

    private EmployeeDto entityToDto(Employee employee) {
//        Employee EmployeeDto = Employee.builder()
//                .employee_id(employee.getEmployee_id())
//                .name(employee.getName())
//                .email(employee.getEmail())
//                .age(employee.getAge())
//                .phoneNo(employee.getPhoneNo())
//                .build();
        return mapper.map(employee, EmployeeDto.class);

    }

    private Employee dtoToEntity(EmployeeDto employeeDto) {
//        EmployeeDto Employee = EmployeeDto.builder()
//                .employee_id(employeeDto.getEmployee_id())
//                .name(employeeDto.getName())
//                .email(employeeDto.getEmail())
//                .phoneNo(employeeDto.getPhoneNo())
//                .gender(employeeDto.getGender())
//                .build();
        return mapper.map(employeeDto, Employee.class);
    }


    @Override
    @Transactional
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = dtoToEntity(employeeDto);
        employeeRepository.save(employee);
        logger.info(employee.getAddressDetails().toString());
       // ModelMapper modelMapper = new ModelMapper();
        EmployeeDto employeeDto1 = mapper.map(employee, EmployeeDto.class);
        return employeeDto1;
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employeeDto) {

        Employee resourceNotFound = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ResourceNot Found","Please give correct EmployeeId"));
        resourceNotFound.setEmployee_id(employeeDto.getEmployee_id());
        resourceNotFound.setAge(employeeDto.getAge());
        resourceNotFound.setName(employeeDto.getName());
        resourceNotFound.setEmail(employeeDto.getEmail());
        resourceNotFound.setGender(employeeDto.getGender());
        resourceNotFound.setPhoneNo(employeeDto.getPhoneNo());
        resourceNotFound.setAddressDetails(employeeDto.getAddressDetails());
        resourceNotFound.setWorkExperiences( employeeDto.getWorkExperiences());

        employeeRepository.save(resourceNotFound);

        return entityToDto(resourceNotFound);
    }

    @Override
    public void delete( Long id) {

        Employee resourceNotFound = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(resourceNotFound);

    }

    @Override
    public List<Employee> getAll() {

        List<Employee> all = employeeRepository.findAll();

        return all;
    }

    @Override
    public Optional<Employee> findByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    @Override
    public boolean exist(String email){
        return employeeRepository.existsByEmail(email);
    }
    @Override
    public EmployeeDto getById(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not found","Please check the Employee Id "));
        return entityToDto(employee);
    }
}
