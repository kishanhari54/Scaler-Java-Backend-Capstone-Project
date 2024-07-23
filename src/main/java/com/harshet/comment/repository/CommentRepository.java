package com.harshet.comment.repository;

import com.harshet.comment.models.comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<comment, Long> {
    List<comment> findByPostId(Long postId);
}