package com.nhnacademy.jdbc.board.repository.impl;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.repository.PostRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private final SqlSession sqlSession;

    public PostRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Post> findAll() {
        return sqlSession.selectList("post.selectPosts");
    }

    @Override
    public Optional<Post> findById(Long postId) {
        return sqlSession.selectOne("post.selectPost");
    }
}
