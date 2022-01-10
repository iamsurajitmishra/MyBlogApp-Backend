package com.iamsurajit.myblog.service;

import com.iamsurajit.myblog.payload.PostDto;

import java.util.List;

public interface PostService {
    //create post
    PostDto createPost(PostDto postDto);
    //update post
    PostDto updatePost(PostDto postDto,Long id);
    //get all post
    List<PostDto> getAllPost(int pageNo,int pageSize);
    //get post by ID
    PostDto getPostById(Long id);
    //delete post by id
    void deletePostById(Long id);


}
