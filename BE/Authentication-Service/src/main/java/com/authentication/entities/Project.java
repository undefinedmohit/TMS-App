package com.authentication.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length= 500, nullable = false, unique= true)
    String name;

    @Column(length= 500, nullable = false, unique= false)
    String description;

    @Column(nullable = false)
    LocalDate startDate;
    @Column(nullable = false)
    LocalDate endDateTime;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
