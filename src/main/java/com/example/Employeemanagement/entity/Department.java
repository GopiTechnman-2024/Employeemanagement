package com.example.Employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Department")
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int departmentId;

    @Getter
    @Setter
    private String departmentName;
}
