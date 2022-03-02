package com.pidevteam.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pidevteam.entity.Task;
import com.pidevteam.entity.User;
import com.pidevteam.entity.UserProject;

import java.util.ArrayList;
import java.util.List;

public class ProjectDto {
    private Long id ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserProject> getUserProjects() {
        return userProjects;
    }

    private String name ;
    private String description ;
    private  List<User> users = new ArrayList<>();
    private List<Task> tasks;
    private float estimation;

    public float getEstimation() {
        int done = (int) tasks.stream().filter(task -> task.getStatus() == 4).count();
        if (tasks.size()!=0)

        return done * 100 / tasks.size();
        return 0;
    }

    public void setEstimation(float estimation) {
        this.estimation = estimation;
    }

    @JsonIgnore
    private List<UserProject> userProjects;

    public void setUserProjects(List<UserProject> userProjects) {
        this.userProjects = userProjects;
    }

    public ProjectDto(String name, String description, List<User> users, List<Task> tasks) {
        this.name = name;
        this.description = description;
        this.users = users;
        this.tasks = tasks;
    }

    public ProjectDto(Long id, String name, String description, List<User> users, List<Task> tasks, float estimation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
        this.tasks = tasks;
        this.estimation = estimation;
    }

    public ProjectDto() {
        super();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        userProjects.forEach(up->this.users.add(up.getUser()));
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

