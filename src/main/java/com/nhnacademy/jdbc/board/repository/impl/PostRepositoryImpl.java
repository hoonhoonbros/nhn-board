package com.nhnacademy.jdbc.board.repository.impl;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import com.nhnacademy.jdbc.board.mapper.PostMapper;
import com.nhnacademy.jdbc.board.repository.PostRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostMapper postMapper;

    @Override
    public List<Post> findAll() {
        return postMapper.selectPosts();
    }

    @Override
    public Optional<Post> findById(Long postId) {
        return postMapper.selectPost(postId);
    }

    @Override
    public void save(PostNewRequest postRequest) {
        postMapper.insertPost(postRequest);
    }

    @Override
    public void saveReply(PostNewRequest postRequest) {
        postMapper.insertReplyPost(postRequest);
    }

    public void increaseSeqNumber(Long parentPostId) {
//        long countAllPosts = postMapper.countAllPosts();
        List<Post> posts = postMapper.selectPosts();
//        Post post;
//        for(long i = parentPostId+1; i <= countAllPosts; i++){
//            post = findById(i).get();
//            postMapper.updateReplySequence(post.getSequenceNumber());
//        }

        posts.forEach(post -> {
            long postNo = post.getPostNo();
            if (postNo > parentPostId) {
                postMapper.updateReplySequence(postNo);
            }
        });

    }
}
