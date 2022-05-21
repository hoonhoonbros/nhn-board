package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostDetailViewVo;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<Post> findAll();

    Optional<PostDetailViewVo> findById(Long postId);

    void save(PostNewRequest postRequest);

    void saveReply(PostNewRequest postRequest);

    public void increaseSeqNumber(Long parentPostId);
}
