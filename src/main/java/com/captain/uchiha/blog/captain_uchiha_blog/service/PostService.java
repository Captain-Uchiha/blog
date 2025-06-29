package com.captain.uchiha.blog.captain_uchiha_blog.service;

import com.captain.uchiha.blog.captain_uchiha_blog.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    PostDto getPostById(Long id);
    List<PostDto> getAllPost();
}
