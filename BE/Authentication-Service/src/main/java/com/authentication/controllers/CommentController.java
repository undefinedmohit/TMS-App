package com.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.entities.Comment;
import com.authentication.services.CommentService;
import com.authentication.utility.APIResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/private/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public APIResponse getCommentsByTaskId(@RequestParam Long taskId)
    {
        return commentService.getCommentsByTaskId(taskId);
    }

    @PostMapping
    public APIResponse saveCommentByTaskId(@RequestBody Comment comment)
    {
        return commentService.addCommentByTaskId(comment);
    }
}
