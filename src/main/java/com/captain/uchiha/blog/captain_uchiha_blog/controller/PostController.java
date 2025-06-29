package com.captain.uchiha.blog.captain_uchiha_blog.controller;


import com.captain.uchiha.blog.captain_uchiha_blog.payload.PostDto;
import com.captain.uchiha.blog.captain_uchiha_blog.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {


    PostServiceImpl postService ;
    public PostController(PostServiceImpl postService)
    {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
       return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
}
