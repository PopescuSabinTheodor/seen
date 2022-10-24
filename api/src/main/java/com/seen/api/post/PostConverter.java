package com.seen.api.post;

import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    public Post toPost(PostDto postDto) {
        return Post.builder()
                .content(postDto.getContent())
                .description(postDto.getDescription())
                .downVotes(postDto.getDownVotes())
                .shares(postDto.getShares())
                .upVotes(postDto.getUpVotes())
                .build();
    }
}
