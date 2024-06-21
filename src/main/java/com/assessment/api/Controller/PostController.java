package com.assessment.api.Controller;

import com.assessment.api.Model.Post;
import com.assessment.api.Services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);


    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        logger.info("Creating post");
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        logger.info("Getting all posts");
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        logger.info("Getting post by id: {}", id);
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }
    @GetMapping("/title")
    public ResponseEntity<List<Post>> getPostByTitle(@RequestParam String title){
        logger.info("Getting Post by Title");
        List<Post> posts = postService.getPostByTitle(title);
        return ResponseEntity.ok(posts);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostByTitle(@PathVariable Long userId){
        logger.info("Getting posts by user");
        List<Post> posts = postService.getPostsByUserId(userId);
        return ResponseEntity.ok(posts);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        logger.info("Post has Successfully been Deleted");
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        logger.info("Post has Successfully been updated");
        Post updatedPost = postService.updatePost(id, postDetails);
        return ResponseEntity.ok(updatedPost);
    }


}
