package com.authentication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

    Optional<Comment> findByTaskId(Long taskId);
    
}
