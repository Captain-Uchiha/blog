package com.captain.uchiha.blog.captain_uchiha_blog.service.impl;


import com.captain.uchiha.blog.captain_uchiha_blog.entity.Post;
import com.captain.uchiha.blog.captain_uchiha_blog.exceptions.DeletionFailedException;
import com.captain.uchiha.blog.captain_uchiha_blog.exceptions.ResourceNotFoundException;
import com.captain.uchiha.blog.captain_uchiha_blog.exceptions.UpdationFailedException;
import com.captain.uchiha.blog.captain_uchiha_blog.payload.PostDto;
import com.captain.uchiha.blog.captain_uchiha_blog.repository.PostRepository;
import com.captain.uchiha.blog.captain_uchiha_blog.service.PostService;
import com.captain.uchiha.blog.captain_uchiha_blog.utils.PostPayloadUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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



    @Override
    public PostDto getPostById(Long id) {
        try {
            return PostPayloadUtils.getPostDTOromEntity(postRepository.getReferenceById(id));
        } catch (EntityNotFoundException e) {
           throw new ResourceNotFoundException("Post","id",String.valueOf(id));
        }
    }

    @Override
    public List<PostDto> getAllPost() {
            List<PostDto> postDtos = new ArrayList<>();
            for(Post post : postRepository.findAll()){
                postDtos.add(PostPayloadUtils.getPostDTOromEntity(post));
            }
            return postDtos;
    }
    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        // Step 1: Check if post exists
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", String.valueOf(id)));

        try {
            existingPost.setTitle(postDto.getTitle());
            existingPost.setContent(postDto.getContent());
            existingPost.setDescription(postDto.getDescription());

            Post updatedPost = postRepository.save(existingPost);

            return PostPayloadUtils.getPostDTOromEntity(updatedPost);

        } catch (Exception e) {
            throw new UpdationFailedException("Post", "id", String.valueOf(postDto.getId()));
        }
    }


    @Override
    public String deletePost(Long id) {
        try {
            Post existingPost = postRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Post", "id", String.valueOf(id)));
            postRepository.deleteById(existingPost.getId());
            return "Post Deleted Successfully";
        }catch (Exception e){
            throw new DeletionFailedException("Post","id",String.valueOf(id));
        }
    }
}
