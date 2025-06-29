package com.captain.uchiha.blog.captain_uchiha_blog.payload;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String description;

}
