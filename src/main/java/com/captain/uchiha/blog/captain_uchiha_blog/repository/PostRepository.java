package com.captain.uchiha.blog.captain_uchiha_blog.repository;

import com.captain.uchiha.blog.captain_uchiha_blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
