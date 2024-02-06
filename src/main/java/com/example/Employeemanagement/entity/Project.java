package com.example.Employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Project")
public class Project {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int projectId;

    @Getter
    @Setter
    private String projectName;

    //team_lead and team is remaining and status enum is also remaining

    @Getter
    @Setter
    @Temporal(TemporalType.DATE) // Specifies the type of temporal data (DATE, TIME, TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE) // Specifies the type of temporal data (DATE, TIME, TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;



@Getter
@Setter
    @OneToMany
    @JoinColumn(name = "project_id")
    private List<Employee> team;



}
/*
id (long & unique)
name
team (List<Emp>)
Team_lead
Status enum
NEW - By default the Project status will be new till its start_date is after today.
ON-GOING - If the today is between start and end date
ENDED - if the today is after end-date
Start_date
End_dat
 */