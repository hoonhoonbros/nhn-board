package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostDetailViewVo;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface PostService {
    List<Post> getAllPosts();

    PostDetailViewVo getPost(Long postId);

    void newPost(PostNewRequest postRequest, HttpServletRequest request);

    void doReplyPost(PostNewRequest postRequest);
}
