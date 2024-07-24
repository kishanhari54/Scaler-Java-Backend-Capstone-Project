package com.harshet.postservice.services;

import com.harshet.postservice.models.Post;
import com.harshet.postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl {
    @Autowired
    private PostRepository postRepository;


    public Post createPost(Post post) {
        post.setCreatedAt(new Date());
        return postRepository.save(post);
    }


    public Post updatePost(Long postId, String content) {
        Post post = postRepository.findById(postId).orElseThrow();
        post.setContent(content);
        post.setUpdatedAt(new Date());
        return postRepository.save(post);
    }


    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }


    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }


    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow();
    }
}
