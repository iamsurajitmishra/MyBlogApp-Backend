package com.iamsurajit.myblog.controller;


import com.iamsurajit.myblog.payload.PostDto;
import com.iamsurajit.myblog.payload.PostResponseDto;
import com.iamsurajit.myblog.service.PostService;
import com.iamsurajit.myblog.utils.MyBlogConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/*
    Post resources-
    GET->
    /api/v1/posts -> get all post with default pageNo and pageSize
    /api/v1/posts/1
    /api/v1/posts?pageNo=0&pageSize=5
    /api/v1/posts?pageNo=0&pageSize=5&sortBy=title&sortDir=asc

    POST-> /api/v1/posts -> Create post
    PUT -> /api/v1/posts/1
    DELETE -> /api/v1/posts/1

 */
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Get all post
    /*
       Edit pageSize & pageNo here -
     */
    @GetMapping
    public PostResponseDto getPost(@RequestParam(value = "pageNo", defaultValue = MyBlogConstant.DEFAULT_PAGE_NO, required = false) int pageNo,
                                   @RequestParam(value = "pageSize", defaultValue = MyBlogConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                   @RequestParam(value = "sortBy", defaultValue = MyBlogConstant.DEFAULT_SORT_BY, required = false) String sortBy,
                                   @RequestParam(value = "sortDir", defaultValue = MyBlogConstant.DEFAULT_SORT_DIR, required = false) String sortDir) {

        return postService.getAllPost(pageNo, pageSize, sortBy,sortDir);
    }

    //Find post by ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    //Create new post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    //update post
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
    }

    //delete post
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<String>("Post entity deleted successfully.", HttpStatus.OK);
    }
}
