package com.example.Employeemanagement.controller;

import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/getallEmployees")
    public List<Employee> getAllEmployees()
    {
        return  employeeService.getAllEmployees();
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee, @RequestParam("departmentId") Long departmentId) {
        return employeeService.createEmployee(employee, departmentId);
    }
}
