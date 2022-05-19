package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
}
