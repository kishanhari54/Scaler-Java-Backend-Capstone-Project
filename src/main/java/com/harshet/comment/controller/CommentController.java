package com.harshet.comment.controller;

import com.harshet.comment.models.comment;
import com.harshet.comment.services.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping
    public comment createComment(@RequestBody comment comment) {
        return commentService.createComment(comment);
    }

    @PutMapping("/{commentId}")
    public comment updateComment(@PathVariable Long commentId, @RequestBody String content) {
        return commentService.updateComment(commentId, content);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

    @GetMapping("/post/{postId}")
    public List<comment> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/{commentId}")
    public comment getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }
}
