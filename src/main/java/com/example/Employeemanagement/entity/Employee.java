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

    @Getter
    @Setter
    private double salary;

    @Getter
    @Setter
    private String designation;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="department_id")
    Department department;

/*
   @Getter
    @Setter
    private String department;
*/

    @Getter
    @Setter
    private String Address;


    @Getter
    @Setter
    @ElementCollection
    @CollectionTable(name = "Employee_Projects", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "project_id")
    private List<Long> projects;

    public void setDepartment(Department department) {
        this.department = department;
    }
}
