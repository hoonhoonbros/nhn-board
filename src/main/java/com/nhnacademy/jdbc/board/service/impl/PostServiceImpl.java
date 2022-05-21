package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import com.nhnacademy.jdbc.board.repository.PostRepository;
import com.nhnacademy.jdbc.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(Long postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public void newPost(PostNewRequest postRequest) {
        postRepository.save(postRequest);
    }

    @Override
    public void doReplyPost(Long parentPostId, PostNewRequest postRequest) {
        postRepository.increaseSeqNumber(parentPostId);
        postRepository.saveReply(postRequest);
    }
}
