package com.example.Employeemanagement.controller;

import com.example.Employeemanagement.entity.Department;
import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.service.DepartmentService;
import com.example.Employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @GetMapping("/getallDepartments")
    public List<Department> getAllDepartments()
    {
        return  departmentService.getAllDepartments();
    }

    @PostMapping("/createDepartment")
    public Department createDepartment(@RequestBody Department department)
    {
        return departmentService.createDepartment(department);
    }

}
