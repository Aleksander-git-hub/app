package com.cascade.app.service;

import com.cascade.app.entity.Project;
import com.cascade.app.exception.ResourceNotFoundException;
import com.cascade.app.repository.AttributeRepository;
import com.cascade.app.repository.GeometryRepository;
import com.cascade.app.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService
{
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private GeometryRepository geometryRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    public StringBuilder getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (Project project : projects) {
            stringBuilder.append(project.getName()).append(" ")
                    .append(project.getId()).append("\n");
        }
        return stringBuilder;
    }

    // get project by id
    public Project getProjectById(int id) throws ResourceNotFoundException {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));
    }

    // save project
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    // remove project by id
    public String removeProjectById(int id) throws ResourceNotFoundException {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));
        projectRepository.delete(existingProject);
        return "Remove project for this id: " + id;
    }

    // update project by id
    public ResponseEntity<Project> updateProjectById(int id, Project projectName)
            throws ResourceNotFoundException {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));
        existingProject.setName(projectName.getName());
        return ResponseEntity.ok(projectRepository.save(existingProject));
    }
}
