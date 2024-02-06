package com.example.Employeemanagement.repository;


import com.example.Employeemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}

