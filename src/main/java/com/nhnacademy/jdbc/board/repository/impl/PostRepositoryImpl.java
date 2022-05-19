package com.nhnacademy.jdbc.board.repository.impl;

import com.nhnacademy.jdbc.board.domain.Post;
import com.nhnacademy.jdbc.board.repository.PostRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private final SqlSession sqlSession;

    public PostRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Post> findAll() {
        return sqlSession.selectList("post.selectList");
    }
}
