/*
package com.pidevteam.config.seeder;

import com.pidevteam.entity.Task;
import com.pidevteam.repository.ProjectRepository;
import com.pidevteam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskSeeder {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectRepository projectRepository;

    public void seed(){
        if(projectRepository.findAll().isEmpty())
        projectRepository.findAll().forEach( (p) -> {
            taskService.save(new Task("Task 1 ", "Task1", 1, p),"karim");
            taskService.save(new Task("Task 2 ", "Task2", 1, p), "karim");
            taskService.save(new Task("Task 3 ", "Task3", 1, p), "karim");
            taskService.save(new Task("Task 4 ", "Task4", 1, p), "karim");
            taskService.save(new Task("Task 5 ", "Task5", 1, p),"karim");
            taskService.save(new Task("Task 6 ", "Task6", 1, p), "karim");

        });
    }
}
*/
