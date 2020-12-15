package com.cascade.app.service;

import com.cascade.app.entity.Project;
import com.cascade.app.exception.ResourceNotFoundException;
import com.cascade.app.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService
{
    @Autowired
    private ProjectRepository repository;

    // get projects
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    // get project by id
    public Project getProjectById(int id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));
    }

    // save project
    public Project saveProject(Project project) {
        return repository.save(project);
    }

    // remove project by id
    public String removeProjectById(int id) throws ResourceNotFoundException {
        Project existingProject = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));
        repository.delete(existingProject);
        return "Remove project for this id: " + id;
    }

    // update project by id
    public ResponseEntity<Project> updateProjectById(int id, Project projectName)
            throws ResourceNotFoundException {
        Project existingProject = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));
        existingProject.setName(projectName.getName());
        return ResponseEntity.ok(repository.save(existingProject));
    }
}
