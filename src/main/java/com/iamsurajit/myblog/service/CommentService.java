package com.iamsurajit.myblog.service;

import com.iamsurajit.myblog.payload.CommentDto;

public interface CommentService {
    CommentDto addComment(long postID,CommentDto commentDto);
}
