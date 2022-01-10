package com.iamsurajit.myblog.service;

import com.iamsurajit.myblog.payload.PostDto;
import com.iamsurajit.myblog.payload.PostResponseDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PostService {
    //create post
    PostDto createPost(PostDto postDto);
    //update post
    PostDto updatePost(PostDto postDto,Long id);
    //get all post
    PostResponseDto getAllPost(int pageNo, int pageSize, String sortBy,String sortDir);
    //get post by ID
    PostDto getPostById(Long id);
    //delete post by id
    void deletePostById(Long id);


}
