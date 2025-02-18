package com.microservice.departmentservice.client;

import com.microservice.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("employee/department/{deparmentID}")
    public List<Employee> findByDeparmentId(@PathVariable long deparmentID);

    }
