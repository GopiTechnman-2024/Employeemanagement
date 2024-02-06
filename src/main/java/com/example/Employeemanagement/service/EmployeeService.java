package com.example.Employeemanagement.service;

import com.example.Employeemanagement.entity.Department;
import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.repository.DepartmentRepository;
import com.example.Employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;
    public Employee createEmployee(Employee employee,Long departmentId)
    {

        // Retrieve the Department entity corresponding to the departmentId
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department == null) {
            // Handle if department not found
//            throw new DepartmentNotFoundException("Department not found with ID: " + departmentId);
        }

        // Set the department for the employee
        employee.setDepartment(department);

        // Save the employee entity
        return employeeRepository.save(employee);

    }

    public List<Employee> getAllEmployees() {
         return employeeRepository.findAll();
    }
}
