package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post getPost(Long postId);

    void newPost(PostNewRequest postRequest);

    void doReplyPost(PostNewRequest postRequest);
}
