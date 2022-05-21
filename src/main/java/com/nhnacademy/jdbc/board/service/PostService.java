package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getPosts();

    Post getPost(Long postId);

    void newPost(PostNewRequest postRequest);

    void doReplyPost(PostNewRequest postRequest);
}
