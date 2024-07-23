package com.harshet.comment.services;

import com.harshet.comment.models.comment;
import com.harshet.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class CommentServiceImpl {


    @Autowired
    private CommentRepository commentRepository;


    public comment createComment(comment comment) {
        comment.setCreatedAt(new Date());
        return commentRepository.save(comment);
    }


    public comment updateComment(Long commentId, String content) {
        comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.setContent(content);
        comment.setUpdatedAt(new Date());
        return commentRepository.save(comment);
    }


    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }


    public List<comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }


    public comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow();
    }
}
