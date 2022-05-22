package com.nhnacademy.jdbc.board.service.impl;

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
    public void doReplyPost(PostNewRequest postRequest, HttpServletRequest request) {
        // TODO: 만약 post_depth 가 0이 아니면 게시글이 아닌 답글이므로 UPDATE 를 먼저 호출
        if (postRequest.getPostDepth() != 0) {
            // post_group_seq 1 2 -> 2 3
            postRepository.updatePostGroups(postRequest);
        }
        // 그냥 게시글일 때는 0 + 1 / 답글이 달린 거의 경우에는 위에 업데이트 친 다음 원래 요청의 + 1
        postRepository.saveReply(postRequest, request);
    }

    @Override
    public Post editPost(PostNewRequest postEditRequest) {
        postRepository.modifyPost(postEditRequest);
        return null;
    }


}
