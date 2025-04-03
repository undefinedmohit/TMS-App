package com.authentication.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.authentication.entities.Project;
import com.authentication.repositories.ProjectRepository;
import com.authentication.utility.APIResponse;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public APIResponse saveProject(Project project) {
        APIResponse response = new APIResponse();

            project.setCreatedAt(LocalDateTime.now());
            Project savedProject = projectRepository.save(project);
            response.setData(savedProject);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Project saved successfully!");
            
        return response;
    }

    public APIResponse updateProject(Project project) {
        APIResponse response = new APIResponse();
        Optional<Project> existingProject = projectRepository.findById(project.getId());
        if (!existingProject.isPresent()) {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Project not found!");
            response.setData(null);
        }
        else{
            Project project2 = existingProject.get();
            project2.setDescription(project.getDescription());
            project2.setEndDateTime(project.getEndDateTime());
            project2.setStartDate(project.getStartDate());
            project2.setName(project.getName());
            project2.setUpdatedAt(LocalDateTime.now());
            Project savedProject = projectRepository.save(project2);
            response.setData(savedProject);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Project saved successfully!");
            
        }
        return response;
    }
    public APIResponse deleteProjectById(Long projectId) {
        APIResponse response = new APIResponse();
        Optional<Project> existingProject = projectRepository.findById(projectId);
        if (!existingProject.isPresent()) {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Project not found!");
            response.setData(null);
        }
        else{
            Project project2 = existingProject.get();
            projectRepository.delete(project2);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Project deleted successfully!");
            
        }
        return response;
    }

    public APIResponse getAllProjects()
    {
        APIResponse response = new APIResponse();
        List<Project> allProjects = projectRepository.findAll();
        response.setData(allProjects);
        response.setMessage("Fetched all projects!!");;
        response.setStatus(HttpStatus.OK);
        return response;
    }
    
    public APIResponse getProjectbyId(Long projectId) {
        APIResponse response = new APIResponse();
        Optional<Project> existingProject = projectRepository.findById(projectId);
        if (!existingProject.isPresent()) {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Project not found!");
            response.setData(null);
        }
        else{
            response.setData(existingProject.get());
            response.setStatus(HttpStatus.OK);
            response.setMessage("Project found successfully!");
            
        }
        return response;
    }

}
