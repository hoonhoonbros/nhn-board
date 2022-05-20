package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<Post> findAll();

    Optional<Post> findById(Long postId);

    int save(PostNewRequest postRequest);
}
