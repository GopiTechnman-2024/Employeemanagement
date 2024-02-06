package com.example.Employeemanagement.service;

import com.example.Employeemanagement.entity.Department;
import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department createDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

}