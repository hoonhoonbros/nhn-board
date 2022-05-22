package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.page.Pageable;
import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import com.nhnacademy.jdbc.board.domain.user.User;
import com.nhnacademy.jdbc.board.repository.PostRepository;
import com.nhnacademy.jdbc.board.repository.UserRepository;
import com.nhnacademy.jdbc.board.service.PostService;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public List<Post> getPagingPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional<Post> getPost(Long postNo) {
        return postRepository.findById(postNo);
    }

    @Override
    public void newPost(PostNewRequest postRequest, HttpServletRequest request) {
        String username = (String) request.getSession(false).getAttribute("username");
        Optional<User> user = userRepository.findByUserName(username);
        postRequest.setUserNo(user.get().getUserNo());
        postRepository.save(postRequest);
    }

    @Override
    public void doReplyPost(PostNewRequest postRequest) {
        postRepository.increaseSeqNumber(postRequest.getParentPostNo());
        postRepository.saveReply(postRequest);
    }
}
