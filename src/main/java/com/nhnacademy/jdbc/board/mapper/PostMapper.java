package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.post.Post;

import java.util.List;

public interface PostMapper {
    List<Post> selectPosts();
}
