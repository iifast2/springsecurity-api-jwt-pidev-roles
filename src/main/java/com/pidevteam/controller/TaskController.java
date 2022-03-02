package com.pidevteam.controller;

import com.pidevteam.entity.Task;
import com.pidevteam.entity.dto.ProjectDto;
import com.pidevteam.service.TaskService;
import com.pidevteam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value ="/tasks")
    public List<Task> listTask(){return taskService.findAll();}
    @GetMapping(value = "/tasks/{id}")
    public Task getOne(@PathVariable(value = "id") Long id){ return taskService.findById(id);}
    @PostMapping(value = "/tasks")
    public Task saveTask(@RequestBody Task task){
        Task tsk = taskService.save(task, SecurityContextHolder.getContext().getAuthentication().getName());

        return tsk;}
    @PutMapping(value = "/tasks")
    public Task update(@RequestBody Task task){
        Task tsk = taskService.update(task, SecurityContextHolder.getContext().getAuthentication().getName());
       simpMessagingTemplate.convertAndSend("/socket-front-project/" + task.getProject().getId(), modelMapper.map(tsk.getProject(), ProjectDto.class));

        return tsk;

    }
    @PutMapping(value = "/tasks/join")
    public Task join(@RequestBody Task task){
        if(task.getUsernames() == null)
        {
            ArrayList<String> usernames = new ArrayList<String>();
            usernames.add(SecurityContextHolder.getContext().getAuthentication().getName());
            task.setUsernames(usernames);
        }
        else if (!task.getUsernames().contains(SecurityContextHolder.getContext().getAuthentication().getName())) {
            task.getUsernames().add(SecurityContextHolder.getContext().getAuthentication().getName());
        }
        else {
            task.getUsernames().remove(SecurityContextHolder.getContext().getAuthentication().getName());
        }
       return taskService.update(task);

    }
    @DeleteMapping(value = "/tasks/{id}")
    public void delete(@PathVariable(name = "id") Long id){taskService.deleteById(id);}

    // For Test
    @GetMapping(value = "/tasks/description/{d}")
    public Task findByDescription(@PathVariable(value = "d") String d){
        return taskService.findByDescription(d);
    }


}
