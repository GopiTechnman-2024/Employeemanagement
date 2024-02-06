package com.example.Employeemanagement.controller;

import com.example.Employeemanagement.entity.Department;
import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.entity.Project;
import com.example.Employeemanagement.repository.DepartmentRepository;
import com.example.Employeemanagement.service.DepartmentService;
import com.example.Employeemanagement.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentRepository departmentRepository;


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


    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable Long id, @RequestBody Department department)
    {
        Department getDept=departmentService.getById(id);

        getDept.setDepartmentName(department.getDepartmentName());

        Department updateDepart=departmentRepository.save(getDept);

        return ResponseEntity.ok().body(updateDepart);

    }

//    @DeleteMapping("/deleteDepartment/{id}")
//    public ResponseEntity<?> deleteDepartmentById(@PathVariable Long id) {
//        try {
//            departmentService.deleteDepartmentById(id);
//            return ResponseEntity.ok().build();
//        } catch (EntityNotFoundException | IllegalStateException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }


}
