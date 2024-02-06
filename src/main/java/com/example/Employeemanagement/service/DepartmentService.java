package com.example.Employeemanagement.service;

import com.example.Employeemanagement.entity.Department;
import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.entity.Project;
import com.example.Employeemanagement.repository.DepartmentRepository;
import com.example.Employeemanagement.repository.EmployeeRepository;
import com.example.Employeemanagement.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Department createDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with ID: " + id));
    }

//    public void deleteDepartmentById(Long departmentId) {
//        Department department = departmentRepository.findById(departmentId)
//                .orElseThrow(() -> new EntityNotFoundException("Department not found with ID: " + departmentId));
//
//        // Check if there are any employees associated with the department
//        List<Employee> employeesInDepartment = employeeRepository.findByDepartment(department);
//        if (!employeesInDepartment.isEmpty()) {
//            throw new IllegalStateException("Cannot delete department. Employees are associated with this department.");
//        }
//
//        // If no employees associated, proceed with deleting the department
//        departmentRepository.deleteById(departmentId);
//    }

}