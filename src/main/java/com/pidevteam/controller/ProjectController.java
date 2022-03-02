package com.pidevteam.controller;

import com.pidevteam.entity.Project;
import com.pidevteam.entity.dto.ProjectDto;
import com.pidevteam.service.ProjectService;
import com.pidevteam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ProjectController {
    @Autowired
    ModelMapper modelMapper;
    private final ProjectService projectService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }


    /*@GetMapping(value="/projects")
    public List<ProjectDto> listProject() {

        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")) ?
                projectService.findAll()
                        .stream().map(project -> modelMapper.map(project, ProjectDto.class)).collect(Collectors.toList()) :

                userService.findOne(SecurityContextHolder.getContext().getAuthentication()
                .getName()).getUserProjects().stream().map(UserProject::getProject).collect(Collectors.toList())
                       .stream().map(project -> modelMapper.map(project,ProjectDto.class)).collect(Collectors.toList());
*/
//        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
//                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")) ?
//                projectService.findAll():  userService.findOne(SecurityContextHolder.getContext().getAuthentication()
//                .getName()).getUserProjects().stream().map(UserProject::getProject).collect(Collectors.toList());
    //}


    @GetMapping(value = "/projects/{id}")
    public ProjectDto getOne(@PathVariable(value = "id") Long id){
        return modelMapper.map(projectService.findById(id),ProjectDto.class);
    }

    @PostMapping(value="/projects")
    public ProjectDto saveProject(@RequestBody Project project){
        return modelMapper.map(projectService.save(project),ProjectDto.class);
    }

    @DeleteMapping(value = "/projects/{id}" )
    public void delete(@PathVariable(name = "id") Long id){
        projectService.deleteById(id);
    }

    @PutMapping(value = "/projects" )
    public ProjectDto update(@RequestBody Project p){
        return modelMapper.map(projectService.update(p),ProjectDto.class);
    }



    @GetMapping(value = "/projects/name/{n}")
    public Project findByName(@PathVariable(value = "n") String name){
        return projectService.findByName(name);
    }
}
