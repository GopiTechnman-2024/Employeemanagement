package com.example.Employeemanagement.service;

import com.example.Employeemanagement.entity.Department;
import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.repository.DepartmentRepository;
import com.example.Employeemanagement.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;
    public Employee createEmployee(Employee employee,Long departmentId)
    {

        // Retrieve the Department entity corresponding to the departmentId
//        Department department = departmentRepository.findById(departmentId).orElse(null);
//        if (department == null) {
//            // Handle if department not found
////            throw new DepartmentNotFoundException("Department not found with ID: " + departmentId);
//        }
//
//        // Set the department for the employee
//        employee.setDepartment(department);

        // Save the employee entity
        return employeeRepository.save(employee);

    }

    public List<Employee> getAllEmployees() {
         return employeeRepository.findAll();
    }


    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + id));
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getHighestSalaryEmployees() {
        // Fetch employees sorted by salary in descending order
        List<Employee> employees = employeeRepository.findAllByOrderBySalaryDesc();

        // Check if there are any employees
        if (!employees.isEmpty()) {
            // Get the highest salary
            double highestSalary = employees.get(0).getSalar();
            // Find all employees with the highest salary
            return employeeRepository.findBySalary(highestSalary);
        } else {
            return employees; // Return empty list if no employees
        }
    }

    public List<Map<String, Object>> getTotalSalaryByDepartment() {
        List<Object[]> result = employeeRepository.getTotalSalaryByDepartment();

        return result.stream()
                .map(obj -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("departmentName", obj[0]);
                    map.put("totalSalary", obj[1]);
                    return map;
                })
                .collect(Collectors.toList());
    }
}
