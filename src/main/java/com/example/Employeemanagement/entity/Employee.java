package com.example.Employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long employeeId;

    @Getter
    @Setter
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Getter
    @Setter
    private double salary;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalar()
    {
        return salary;
    }

    @Getter
    @Setter
    private String designation;

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation()
    {
        return designation;
    }
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment()
    {
        return department;
    }

    @Getter
    @Setter
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    @Getter
    @Setter
    @ElementCollection
    @CollectionTable(name = "Employee_Projects", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "project_id")
    private List<Long> projects;

    public void setProjects(List<Long> projects) {
        this.projects = projects;
    }

    public List<Long> getProjects()
    {
        return projects;
    }
    public long getEmployeeId() {
        return employeeId;
    }
}
