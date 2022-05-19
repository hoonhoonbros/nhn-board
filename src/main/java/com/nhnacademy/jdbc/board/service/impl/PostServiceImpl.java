package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.Post;
import com.nhnacademy.jdbc.board.repository.PostRepository;
import com.nhnacademy.jdbc.board.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
