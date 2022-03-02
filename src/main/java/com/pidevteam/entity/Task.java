package com.pidevteam.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @NotNull
    @Size(min= 3, message = "Task Label Length Should Be at min 3 !")
    private String label;

    @NotNull
    private String description;
    private String problem;

    @NotNull
    private Integer status;


        private ArrayList<String> usernames;
        @ManyToOne
        @JsonIgnoreProperties({"tasks","userProjects"})
        private Project project ;

        @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("task")
        private List<Resource> resources;

    public Task(String label, String description, Integer status, Project project,ArrayList<String> usernames) {
        this.label = label;
        this.description = description;
        this.status = status;
        this.usernames = usernames;
        this.project = project;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("task")
    private List<Log> logs;


    public Task(String label, String description, Integer status, Project project) {
        this.label = label;
        this.description = description;
        this.status = status;
        this.project = project;
    }

    public Task() {
    }


    public List <Log> getLogs() {
        return logs;
    }

    public void setLogs(List <Log> logs) {
        this.logs = logs;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(ArrayList<String> usernames) {
        this.usernames = usernames;
    }
}
