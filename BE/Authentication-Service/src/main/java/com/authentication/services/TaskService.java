package com.authentication.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.authentication.entities.Project;
import com.authentication.entities.Task;
import com.authentication.repositories.ProjectRepository;
import com.authentication.repositories.TaskRepository;
import com.authentication.utility.APIResponse;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public APIResponse createTask(Task task) {
        APIResponse response = new APIResponse();
        Optional<Project> existingProject = projectRepository.findById(task.getProjectId());
        if(existingProject.isPresent())
        {
            task.setCreatedAt(LocalDateTime.now());
            Task createdTask = taskRepository.save(task);
            response.setData(createdTask);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Task created successfully!");
        }
        else{
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Project not found!");
        }
        return response;
    }

    public APIResponse updateTask(Task taskObj) {
        APIResponse response = new APIResponse();
        Optional<Project> existingProject = projectRepository.findById(taskObj.getProjectId());
        Optional<Task> existingtask = taskRepository.findById(taskObj.getId());
        if(existingtask.isPresent() && existingProject.isPresent())
        {
            Task task = existingtask.get();
        task.setAssignedUserId(taskObj.getAssignedUserId());
        task.setUpdatedAt(LocalDateTime.now());
        task.setDescription(taskObj.getDescription());
        task.setPriority(taskObj.getPriority());
        task.setStatus(taskObj.getStatus());
        task.setDueDate(taskObj.getDueDate());
        task.setTitle(taskObj.getTitle());
        task.setProjectId(existingProject.get().getId());
        taskRepository.save(task);
        response.setData(task);
        response.setStatus(HttpStatus.OK);
        response.setMessage("Task updated successfully!");
        }
        else{
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Project not found!");
        }
        return response;

    }

    public APIResponse deleteTask(Long taskId) {
        APIResponse response = new APIResponse();
        Optional<Task> task = taskRepository.findById(taskId);

        if (task.isPresent()) {
            taskRepository.delete(task.get());
            response.setData(null);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Task deleted successfully!");
        } else {
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Task not found!");
        }
        return response;
    }

    public APIResponse getTaskById(Long taskId) {
        APIResponse response = new APIResponse();
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent()) {
            response.setData(task);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Task found successfully!");
        } else {
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Task not found!");
        }
        return response;
    }

    public APIResponse getTaskByProjectId(Long projectId) {
        APIResponse response = new APIResponse();
        List<Task> task = taskRepository.findByProjectId(projectId);
        if (!task.isEmpty()) {
            response.setData(task);
            response.setStatus(HttpStatus.OK);
            response.setMessage("Tasks  found successfully project id " + projectId + "!");
        } else {
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Task not found!");
        }
        return response;
    }
}
