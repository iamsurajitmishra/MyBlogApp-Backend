package com.iamsurajit.myblog.service.impl;

import com.iamsurajit.myblog.exception.ResourceNotFoundException;
import com.iamsurajit.myblog.model.Comment;
import com.iamsurajit.myblog.model.Post;
import com.iamsurajit.myblog.payload.CommentDto;
import com.iamsurajit.myblog.repository.CommentRepository;
import com.iamsurajit.myblog.repository.PostRepository;
import com.iamsurajit.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository,PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto addComment(long postID,CommentDto commentDto) {
        //map commentDto to comment
        Comment comment = mapToCommentEntity(commentDto);
        //retrieve the post entity by id
        Post post = postRepository.findById(postID).orElseThrow(()-> new ResourceNotFoundException("post","id",postID));
        //set the post to the comment
        comment.setPost(post);

        //save the comment entity
        Comment reponseComment=commentRepository.save(comment);
        return mapToCommentDto(reponseComment);
    }

    //helper

    //Map comment to Entity
    private Comment mapToCommentEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());

        return comment;
    }

    //Map entity to comment
    private CommentDto mapToCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setBody(comment.getBody());
        commentDto.setEmail(comment.getEmail());
        return commentDto;
    }

}
