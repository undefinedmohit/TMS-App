package com.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.entities.Project;
import com.authentication.services.ProjectService;
import com.authentication.utility.APIResponse;


@RestController
@RequestMapping("/private/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    APIResponse getAllProjects()
    {
        return projectService.getAllProjects();
    }

    @GetMapping("/id")
    APIResponse getProjectById(@RequestParam Long projectId)
    {
        return projectService.getProjectbyId(projectId);
    }

    @PostMapping
    APIResponse saveProject(@RequestBody Project project)
    {
        return projectService.saveProject(project);
    }

    @PutMapping
    APIResponse updateProject(@RequestBody Project project)
    {
        return projectService.updateProject(project);
    }

    @DeleteMapping
    APIResponse deleteProjectById(@RequestParam Long projectId)
    {
        return projectService.deleteProjectById(projectId);
    }
}
