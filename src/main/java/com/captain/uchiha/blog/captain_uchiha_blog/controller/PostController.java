package com.captain.uchiha.blog.captain_uchiha_blog.controller;


import com.captain.uchiha.blog.captain_uchiha_blog.payload.PostDto;
import com.captain.uchiha.blog.captain_uchiha_blog.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/{postId}")
    public  ResponseEntity<PostDto> getPost(@PathVariable("postId") Long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @GetMapping()
    public  ResponseEntity<List<PostDto>> getAllPost(){
        return new ResponseEntity<>(postService.getAllPost(),HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable("postId") Long id){
        return new ResponseEntity<>(postService.updatePost(postDto,id), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public  ResponseEntity<String> deletePost(@PathVariable("postId") Long id){
        return new ResponseEntity<>(postService.deletePost(id),HttpStatus.OK);
    }
}
