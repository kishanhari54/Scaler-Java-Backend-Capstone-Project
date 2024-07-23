package com.harshet.postservice.controllers;


import com.harshet.postservice.client.UserProfileClient;
import com.harshet.postservice.models.Post;
import com.harshet.postservice.services.PostServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {


    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private UserProfileClient userProfileClient;
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        if (!userProfileClient.checkUserExists(post.getUserId())) {
            return null;
        }
        return postService.createPost(post);


    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody String content) {
        return postService.updatePost(postId, content);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }
}
