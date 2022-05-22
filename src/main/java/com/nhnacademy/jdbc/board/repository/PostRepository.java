package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.page.Pageable;
import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

public interface PostRepository {
    List<Post> findAll(Pageable pageable);

    Optional<Post> findById(Long postNo);

    void save(PostNewRequest postRequest);

    void saveReply(PostNewRequest postRequest, HttpServletRequest request);

    void modifyPost(PostNewRequest postEditRequest, String userName);

    void removePostById(Long postNo);
}
