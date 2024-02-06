package com.example.Employeemanagement.repository;

import com.example.Employeemanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
