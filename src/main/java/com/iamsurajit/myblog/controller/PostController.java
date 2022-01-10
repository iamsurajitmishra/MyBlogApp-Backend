package com.iamsurajit.myblog.controller;

import com.iamsurajit.myblog.model.Post;
import com.iamsurajit.myblog.payload.PostDto;
import com.iamsurajit.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<PostDto> getPost(@RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
                                 @RequestParam(value = "pageSize",defaultValue = "5",required = false) int pageSize) {

        return postService.getAllPost(pageNo,pageSize);
    }

    //Find post by ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    //Create new post
    @PostMapping("/")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    //update post
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable(name = "id") long id){
        return new ResponseEntity< PostDto >(postDto,HttpStatus.OK);
    }

    //delete post
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<String>("Post entity deleted successfully.",HttpStatus.OK);
    }
}
