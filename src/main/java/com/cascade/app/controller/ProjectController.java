package com.cascade.app.controller;

import com.cascade.app.entity.Project;
import com.cascade.app.exception.ResourceNotFoundException;
import com.cascade.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController
{
    @Autowired
    private ProjectService service;

    // get projects
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }

    // get project by id
    @GetMapping("/projects/{id}")
    public Project getProjectById(@PathVariable int id) throws ResourceNotFoundException {
        return service.getProjectById(id);
    }

    // save project
    @PostMapping("/projects")
    public Project saveProject(@RequestBody Project project) {
        return service.saveProject(project);
    }

    // remove project by id
    @DeleteMapping("/projects/{id}")
    public String removeProjectById(@PathVariable int id) throws ResourceNotFoundException {
        return service.removeProjectById(id);
    }

    // update project by id
    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProjectById(@PathVariable(value = "id") int id,
            @Validated @RequestBody Project project) throws ResourceNotFoundException {
        return service.updateProjectById(id, project);
    }

}
