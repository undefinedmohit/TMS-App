package com.authentication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByProjectId(Long projectId);
    
}
