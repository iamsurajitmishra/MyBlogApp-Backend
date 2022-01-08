package com.iamsurajit.myblog.service;

import com.iamsurajit.myblog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();
}
