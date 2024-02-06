package com.example.Employeemanagement.controller;

import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.repository.EmployeeRepository;
import com.example.Employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/getallEmployees")
    public List<Employee> getAllEmployees()
    {
        return  employeeService.getAllEmployees();
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee, @RequestParam("departmentId") Long departmentId) {
        return employeeService.createEmployee(employee, departmentId);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id,@RequestBody Employee employee)
    {
        Employee getEmp=employeeService.getById(id);
        getEmp.setAddress(employee.getAddress());
        getEmp.setName(employee.getName());
        getEmp.setSalary(employee.getSalar());
        getEmp.setDesignation(employee.getDesignation());
//        getEmp.setDepartment(employee.getDepartment());
//        getEmp.setProjects(employee.getProjects());

        Employee updateEmp=employeeRepository.save(getEmp);

        return ResponseEntity.ok().body(updateEmp);

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        Employee getEmp=employeeRepository.getById(id);
        employeeRepository.delete(getEmp);

        employeeService.deleteEmployeeById(id);
        return "Employee deleted";
    }

    @GetMapping("/employee/highest-salary")
    public ResponseEntity<List<Employee>> getHighestSalaryEmployees() {
        List<Employee> highestSalaryEmployees = employeeService.getHighestSalaryEmployees();
        if (highestSalaryEmployees.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(highestSalaryEmployees);
        }
    }


    @GetMapping("employee/total-salary-by-department")
    public List<Map<String, Object>> getTotalSalaryByDepartment() {
        return employeeService.getTotalSalaryByDepartment();
    }



}
