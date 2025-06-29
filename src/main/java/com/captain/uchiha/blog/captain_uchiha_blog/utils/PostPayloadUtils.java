package com.captain.uchiha.blog.captain_uchiha_blog.utils;

import com.captain.uchiha.blog.captain_uchiha_blog.entity.Post;
import com.captain.uchiha.blog.captain_uchiha_blog.payload.PostDto;

public class PostPayloadUtils {


    public static Post getPostEntityFromDTO(PostDto postDto)
    {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        return post;
    }

     public static PostDto getPostDTOromEntity(Post post)
    {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        postDto.setTitle(post.getTitle());
        return postDto;
    }



}
