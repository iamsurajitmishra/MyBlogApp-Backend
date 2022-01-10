package com.iamsurajit.myblog.service.impl;

import com.iamsurajit.myblog.exception.ResourceNotFoundException;
import com.iamsurajit.myblog.model.Post;
import com.iamsurajit.myblog.payload.PostDto;
import com.iamsurajit.myblog.repository.PostRepository;
import com.iamsurajit.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// @Service will make
@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    //@Autowired postRepository
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //Create a new row on the Post table in DB
    @Override
    public PostDto createPost(PostDto postDto) {
        Post p1 = mapToEntity(postDto);

        //convert DTO to entity
        Post newPost = postRepository.save(p1);

        //convert entity to DTO
        PostDto postResponse = mapToDto(newPost);

        return postResponse;
    }

    //update post
    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        //set the updated values
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        //returns updated post
        Post updatedPost =postRepository.save(post);
        return mapToDto(post);
    }

    //Return all post as List<PostDto>
    @Override
    public List<PostDto> getAllPost(int pageNo,int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    //Return Post by Id
    public PostDto getPostById(Long id) {
        return postRepository.findById(id).map(post -> (mapToDto(post)))
                .orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
    }

    // delete post by Id
    @Override
    public void deletePostById(Long id) {
        Post p = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post","id",id));
        postRepository.delete(p);
    }


    // Map entity to DTO
    private PostDto mapToDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto;
    }

    //Map DTO to entity
    private Post mapToEntity(PostDto dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());
        return post;
    }

}
