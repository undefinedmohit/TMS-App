package com.authentication.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.authentication.enums.PriorityLevel;
import com.authentication.enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 100, nullable = false, unique = false)
    String title;
    @Column(length = 500, nullable = true, unique = false)
    String description;
    TaskStatus status;
    LocalDate dueDate;
    PriorityLevel priority;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    @Column(nullable = false)
    Long assignedUserId;
    @Column(nullable = false)
    Long projectId;
}
