package com.iamsurajit.myblog.controller;

import com.iamsurajit.myblog.payload.PostDto;
import com.iamsurajit.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PostController {
    private PostService postService;

   public PostController(PostService postService){
       this.postService = postService;
   }


   @GetMapping("/posts")
   public List<PostDto> getPost(){
      return  postService.getAllPost();
   }


    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return  new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.CREATED);
    }
}
