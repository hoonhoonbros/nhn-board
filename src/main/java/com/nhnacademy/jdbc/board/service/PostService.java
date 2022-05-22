package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.page.Pageable;
import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

public interface PostService {
    List<Post> getPagingPosts(Pageable pageable);

    Optional<Post> getPost(Long postNo);

    void newPost(PostNewRequest postRequest, HttpServletRequest request);

    void doReplyPost(PostNewRequest postRequest);
}
