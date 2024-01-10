package com.microservice.employeeservice.controller;

import com.microservice.employeeservice.model.Employee;
import com.microservice.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("add method is called.");
        employeeRepository.addEmployee(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("findAll method is called.");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id){
        LOGGER.info("findbyId method is called.");
        System.out.println("id is :" +id );
        return employeeRepository.findById(id);
    }
    @GetMapping("/department/{deparmentID}")
    public List<Employee> findByDeparmentId(@PathVariable long deparmentID){
        LOGGER.info("findByDeparmentId method is called.");
        return employeeRepository.findByDepartmentId(deparmentID);
    }

}
