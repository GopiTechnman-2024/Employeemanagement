package com.example.Employeemanagement.repository;

import com.example.Employeemanagement.entity.Department;
import com.example.Employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Method to find all employees sorted by salary in descending order
    List<Employee> findAllByOrderBySalaryDesc();

    // Method to find employees by salary
    List<Employee> findBySalary(double salary);

    @Query("SELECT e.department.departmentName, SUM(e.salary) " +
            "FROM Employee e " +
            "JOIN e.department d " +
            "GROUP BY d.departmentName")
    List<Object[]> getTotalSalaryByDepartment();

}
