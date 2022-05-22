package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface PostService {
    List<Post> getAllPosts();

    Post getPost(Long postId);

    void newPost(PostNewRequest postRequest, HttpServletRequest request);

    void doReplyPost(PostNewRequest postRequest, HttpServletRequest request);

    Post editPost(PostNewRequest postEditRequest);
}
