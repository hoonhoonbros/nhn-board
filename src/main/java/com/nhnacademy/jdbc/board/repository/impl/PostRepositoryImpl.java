package com.nhnacademy.jdbc.board.repository.impl;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.mapper.PostMapper;
import com.nhnacademy.jdbc.board.repository.PostRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final PostMapper postMapper;

    public PostRepositoryImpl( PostMapper postMapper) {

        this.postMapper = postMapper;
    }

    public List<Post> findAll() {
        return postMapper.selectPosts();
    }

     @Override
    public Optional<Post> findById(Long postId) {
        return postMapper.selectPost(postId);
    }
}
