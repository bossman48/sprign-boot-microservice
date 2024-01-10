package com.microservice.departmentservice.controller;

import com.microservice.departmentservice.client.EmployeeClient;
import com.microservice.departmentservice.model.Department;
import com.microservice.departmentservice.repository.DepartmentRepository;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.debug("Department add method is called.");
        return departmentRepository.addDepartment(department);
    }
    @GetMapping
    public List<Department> findAll()
    {
        LOGGER.debug("Departments are found");
        return departmentRepository.findAll();
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable  Long id){
        LOGGER.debug("Department is found");
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees()
    {
        LOGGER.debug("findAllWithEmployees are found");
        List<Department> departments = departmentRepository.findAll();

        departments.forEach(department ->
                department.setEmployees(employeeClient.findByDeparmentId(department.getId())));
        return departments;
    }


}
