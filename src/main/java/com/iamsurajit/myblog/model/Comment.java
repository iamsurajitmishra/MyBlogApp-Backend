package com.iamsurajit.myblog.model;

import javax.persistence.*;
/*
Comment Entity -
 */

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;

}
