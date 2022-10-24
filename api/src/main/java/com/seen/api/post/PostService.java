package com.seen.api.post;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findPostById(Long postId){
        return postRepository.findById(postId);
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public void editPost(PostDto postDto, Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);

        if(optionalPost.isPresent()) {
            Post editedPost = optionalPost.get();

            editedPost.setDescription(postDto.getDescription());
            editedPost.setContent(postDto.getContent());
            editedPost.setDownVotes(postDto.getDownVotes());
            editedPost.setUpVotes(postDto.getUpVotes());
            editedPost.setShares(postDto.getShares());

            postRepository.save(editedPost);
        }
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
