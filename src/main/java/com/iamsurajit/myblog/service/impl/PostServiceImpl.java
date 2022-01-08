package com.iamsurajit.myblog.service.impl;

import com.iamsurajit.myblog.model.Post;
import com.iamsurajit.myblog.payload.PostDto;
import com.iamsurajit.myblog.repository.PostRepository;
import com.iamsurajit.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post p1 = new Post();
        p1.setId(postDto.getId());
        p1.setTitle(postDto.getTitle());
        p1.setDescription(postDto.getDescription());
        p1.setContent(postDto.getContent());

        //save entity
        Post newPost=postRepository.save(p1);

        //convert entity to DTO
        PostDto postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setContent(newPost.getContent());

        return postResponse;
    }
}
