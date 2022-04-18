package com.iamsurajit.myblog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 User resource -

GET -> /api/v1/user -> Get all user


 */


@RestController
@RequestMapping("/api/v1/users")

public class UserController {

    @GetMapping
    public String getUser(){
        return "User1";
    }

    @PostMapping
    public void postUser(){

    }



}
