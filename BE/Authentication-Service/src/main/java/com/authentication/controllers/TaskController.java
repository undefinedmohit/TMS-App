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

import com.authentication.entities.Task;
import com.authentication.services.TaskService;
import com.authentication.utility.APIResponse;

@RestController
@RequestMapping("/private/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    APIResponse createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping
    APIResponse updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping
    APIResponse deleteTask(@RequestParam Long taskId) {
        return taskService.deleteTask(taskId);
    }

    @GetMapping("/getTaskByTaskId")
    APIResponse getByTaskId(@RequestParam Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/getTaskByProjectId")
    APIResponse getTaskByProjectId(@RequestParam Long projectId) {
        return taskService.getTaskByProjectId(projectId);
    }

}
