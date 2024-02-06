package com.example.Employeemanagement.controller;

import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.entity.Project;
import com.example.Employeemanagement.service.EmployeeService;
import com.example.Employeemanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @GetMapping("/getallProjects")
    public List<Project> getAllProjects()
    {
        return  projectService.getAllProjects();
    }

    @PostMapping("/createProject")
    public Project createProject(@RequestBody Project project)
    {
        return projectService.createProject(project);
    }
}
