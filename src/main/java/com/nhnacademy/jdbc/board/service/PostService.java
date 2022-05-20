package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.post.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getPosts();

    Optional<Post> getPost(Long postId);
}
