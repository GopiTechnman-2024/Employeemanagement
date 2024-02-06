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

    public void setProjectName(String name)
    {
        this.projectName=name;
    }

    public String getProjectName()
    {
        return projectName;
    }

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    public void setStartDate(Date date)
    {
        this.startDate=date;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    public void setEndDate(Date date)
    {
        this.endDate=date;
    }

    public Date getEndDate()
    {
        return endDate;
    }

@Getter
@Setter
    @OneToMany
    @JoinColumn(name = "project_id")
    private List<Employee> team;


    public List<Employee> getTeam() {
        return team;
    }
}
