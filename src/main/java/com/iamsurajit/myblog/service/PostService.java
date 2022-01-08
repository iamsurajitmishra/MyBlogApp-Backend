package com.iamsurajit.myblog.service;

import com.iamsurajit.myblog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
