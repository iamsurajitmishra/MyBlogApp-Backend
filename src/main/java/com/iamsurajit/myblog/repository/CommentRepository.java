package com.iamsurajit.myblog.repository;

import com.iamsurajit.myblog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    //Create Comment repository
}
