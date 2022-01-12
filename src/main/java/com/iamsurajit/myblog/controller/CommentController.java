package com.iamsurajit.myblog.controller;

import com.iamsurajit.myblog.payload.CommentDto;
import com.iamsurajit.myblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> addComment(@PathVariable(value = "postId") long postId,
                                                 @RequestBody CommentDto commentDto) {
        return new ResponseEntity<CommentDto>(commentService.addComment(postId, commentDto), HttpStatus.CREATED);
    }

}
