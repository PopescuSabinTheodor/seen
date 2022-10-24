package com.seen.api.post;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;
    private final PostConverter postConverter;

    public PostController(PostService postService, PostConverter postConverter) {
        this.postService = postService;
        this.postConverter = postConverter;
    }

    @PostMapping(value = "/api/post/save")
    public Post addPost(@RequestBody PostDto postDto) {
        Post post = postConverter.toPost(postDto);
        return postService.addPost(post);
    }

    @DeleteMapping(value = "/api/post/delete/{id}")
    public void deletePost(@PathVariable(value = "id") Long postId) {
        postService.deletePost(postId);
    }

    @PutMapping(value = "/api/post/edit/{id}")
    public void editPost(@PathVariable(value = "id") Long postId, @RequestBody PostDto postDto) {
        postService.editPost(postDto, postId);
    }

    @GetMapping(value = "/api/post")
    public Optional<Post> findPostById(@RequestParam(value = "id") Long postId) {
        return postService.findPostById(postId);
    }
}
