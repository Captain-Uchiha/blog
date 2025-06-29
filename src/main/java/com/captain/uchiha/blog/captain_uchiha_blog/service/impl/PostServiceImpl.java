package com.captain.uchiha.blog.captain_uchiha_blog.service.impl;


import com.captain.uchiha.blog.captain_uchiha_blog.entity.Post;
import com.captain.uchiha.blog.captain_uchiha_blog.payload.PostDto;
import com.captain.uchiha.blog.captain_uchiha_blog.repository.PostRepository;
import com.captain.uchiha.blog.captain_uchiha_blog.service.PostService;
import com.captain.uchiha.blog.captain_uchiha_blog.utils.PostPayloadUtils;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl  implements PostService {


    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = PostPayloadUtils.getPostEntityFromDTO(postDto);
        Post response = postRepository.save(post);
        return PostPayloadUtils.getPostDTOromEntity(response);
    }
}
