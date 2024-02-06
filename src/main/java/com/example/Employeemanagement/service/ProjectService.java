package com.example.Employeemanagement.service;

import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.entity.Project;
import com.example.Employeemanagement.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project createProject(Project project)
    {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with ID: " + id));
    }
}
