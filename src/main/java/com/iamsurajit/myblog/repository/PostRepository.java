package com.iamsurajit.myblog.repository;

import com.iamsurajit.myblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    //Creates Post CRUD internally
}
