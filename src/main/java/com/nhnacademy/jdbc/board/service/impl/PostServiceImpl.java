package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import com.nhnacademy.jdbc.board.domain.user.User;
import com.nhnacademy.jdbc.board.repository.PostRepository;
import com.nhnacademy.jdbc.board.repository.UserRepository;
import com.nhnacademy.jdbc.board.service.PostService;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(Long postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public void newPost(PostNewRequest postRequest, HttpServletRequest request) {
        String username = (String) request.getSession(false).getAttribute("username");
        Optional<User> user = userRepository.findByUserName(username);
        postRequest.setUserNo(user.get().getUserNo());
        postRepository.save(postRequest);
    }

    @Override
    public void doReplyPost(Long parentPostId, PostNewRequest postRequest) {
        postRepository.increaseSeqNumber(parentPostId);
        postRepository.saveReply(postRequest);
    }
}
