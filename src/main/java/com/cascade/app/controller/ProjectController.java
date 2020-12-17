package com.cascade.app.controller;

import com.cascade.app.entity.Attribute;
import com.cascade.app.entity.Geometry;
import com.cascade.app.entity.Project;
import com.cascade.app.exception.ResourceNotFoundException;
import com.cascade.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProjectController
{
    @Autowired
    private ProjectService projectService;

    // get projects
    @GetMapping("/projects")
    public List<StringBuilder> getAllProjects() {
        return projectService.getAllProjects();
    }

    // get project by id
    @GetMapping(value = "/projects/{id}")
    public StringBuilder getProjectById(@PathVariable int id) throws ResourceNotFoundException {
        return projectService.getProjectById(id);
    }

    // save project
    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public Project saveProject(Project project) {
        List<Geometry> geometries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Geometry geometry = new Geometry();
            geometry.setName("Geom" + i);
            geometries.add(geometry);
        }
        project.setGeometries(geometries);

        List<Attribute> attributes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Attribute attribute = new Attribute();
            attribute.setName("Attr" + i);
            attributes.add(attribute);
        }
        project.setAttributes(attributes);
        
        return projectService.saveProject(project);
    }

    // remove project by id
    @DeleteMapping("/projects/{id}")
    public String removeProjectById(@PathVariable int id) throws ResourceNotFoundException {
        return projectService.removeProjectById(id);
    }

    // update project by id
    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProjectById(@PathVariable(value = "id") int id,
            /*@Validated @RequestBody*/ Project project) throws ResourceNotFoundException {
        return projectService.updateProjectById(id, project);
    }
}
