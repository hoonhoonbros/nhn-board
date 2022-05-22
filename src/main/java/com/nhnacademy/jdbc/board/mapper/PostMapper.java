package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.page.PageRequest;
import com.nhnacademy.jdbc.board.domain.page.Pageable;
import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import java.util.List;
import java.util.Optional;

public interface PostMapper {
    List<Post> selectPosts(Pageable pageable);

    Optional<Post> selectPost(Long postNo);

    void insertPost(PostNewRequest postRequest);

    void insertReplyPost(PostNewRequest postRequest);

    void updateReplySequence(Long postId);

    Integer selectNumOfPosts();
}
