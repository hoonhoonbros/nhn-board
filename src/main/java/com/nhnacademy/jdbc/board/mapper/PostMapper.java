package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;

import java.util.List;
import java.util.Optional;

public interface PostMapper {
    List<Post> selectPosts();

    Optional<Post> selectPost(Long postId);

    void insertPost(PostNewRequest postRequest);

    void insertReplyPost(PostNewRequest postRequest);

    void updateReplySequence(Long postId);

//    Long countAllPosts();
}
