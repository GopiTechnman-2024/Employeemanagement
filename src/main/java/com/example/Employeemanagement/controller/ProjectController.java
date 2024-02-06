package com.example.Employeemanagement.controller;

import com.example.Employeemanagement.entity.Employee;
import com.example.Employeemanagement.entity.Project;
import com.example.Employeemanagement.repository.ProjectRepository;
import com.example.Employeemanagement.service.EmployeeService;
import com.example.Employeemanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository;


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

    @PutMapping("/updateProject/{id}")
    public ResponseEntity<Project> updateProjectById(@PathVariable Long id, @RequestBody Project project)
    {
        Project getProject=projectService.getById(id);
        getProject.setProjectName(project.getProjectName());
        getProject.setStartDate(project.getStartDate());
        getProject.setEndDate(project.getEndDate());


        Project updateProj=projectRepository.save(getProject);

       return ResponseEntity.ok().body(updateProj);

    }


    @GetMapping("/project/{projectId}/budget")
    public ResponseEntity<Double> getProjectBudget(@PathVariable Long projectId) {
        Project project = projectService.getById(projectId);
        if (project == null) {
            return ResponseEntity.notFound().build();
        }

        List<Employee> employees = project.getTeam();
        double totalSalary = employees.stream().mapToDouble(Employee::getSalar).sum();
        return ResponseEntity.ok(totalSalary);
    }


}
