package com.authentication.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.authentication.entities.Comment;
import com.authentication.repositories.CommentRepository;
import com.authentication.utility.APIResponse;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public APIResponse getCommentsByTaskId(Long taskId)
    {
        APIResponse response = new APIResponse();
        Optional<Comment> commentEntity = commentRepository.findByTaskId(taskId);

        if(commentEntity.isPresent())
        {
            response.setData(commentEntity.get());
            response.setMessage("All comments By TaskId");
            response.setStatus(HttpStatus.OK);

        }
        else{
            response.setData(null);
            response.setMessage("Something went wrong!!");
            response.setStatus(HttpStatus.NOT_FOUND);
        }
        
        return response;
    }
    
    public APIResponse addCommentByTaskId(Comment comment)
    {
        APIResponse response = new APIResponse();

        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);

        response.setData(response);
        response.setMessage("Comment Added successfully for taskId: "+ comment.getTaskId());
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
