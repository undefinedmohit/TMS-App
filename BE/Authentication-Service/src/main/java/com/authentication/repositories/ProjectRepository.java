package com.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authentication.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
