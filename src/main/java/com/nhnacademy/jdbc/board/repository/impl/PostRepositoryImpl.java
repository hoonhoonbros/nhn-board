package com.nhnacademy.jdbc.board.repository.impl;

import com.nhnacademy.jdbc.board.domain.page.Pageable;
import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import com.nhnacademy.jdbc.board.domain.user.User;
import com.nhnacademy.jdbc.board.mapper.PostMapper;
import com.nhnacademy.jdbc.board.mapper.UserMapper;
import com.nhnacademy.jdbc.board.repository.PostRepository;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostMapper postMapper;
    private final UserMapper userMapper;

    @Override
    public List<Post> findAll(Pageable pageable) {
        pageable.setNumOfPosts(postMapper.selectNumOfPosts());
        pageable.paginate();
        return postMapper.selectPosts(pageable);
    }

    @Override
    public Optional<Post> findById(Long postNo) {
        return postMapper.selectPost(postNo);
    }

    @Override
    public void save(PostNewRequest postRequest) {
        postMapper.insertPost(postRequest);
    }

    @Override
    public void saveReply(PostNewRequest postRequest, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        Optional<User> user = userMapper.selectUser(username);
        postRequest.setUserNo(user.get().getUserNo());

        Optional<Post> post = findById(postRequest.getParentPostNo());    // 바로 위 게시글 번호로 찾기
        Post parentPost = post.get();
        Integer depth = parentPost.getPostDepth();
        postRequest.setPostDepth(depth + 1);                               // 뎁스 계산

        postRequest.setPostGroupNo(parentPost.getPostGroupNo());

        // FIXME: post_group_no, post_group_seq, post_depth
        // FIXME: title1(1, 0, 0) -> title_1_1(1, 1, 1) -> title_1_2(1, 2, 1) -> title_1_1_1(1, 2, 2)
        Long parentPostGroupSeq = parentPost.getPostGroupSeq();
        postMapper.updateFreeUpSpace(parentPost);
        parentPost.setPostGroupSeq(parentPostGroupSeq + 1);
        // postRequest.setPostGroupSeq(parentPostGroupSeq); // 상위게시글 바로 다음으로 시퀀스 설정
        postRequest.setPostGroupSeq(parentPost.getPostGroupSeq()); // 상위게시글 바로 다음으로 시퀀스 설정

        postMapper.insertReplyPost(postRequest);
    }

    @Override
    public void modifyPost(PostNewRequest postEditRequest, String userName) {
        User user = userMapper.selectUser(userName).get();
        postEditRequest.setUserNo(user.getUserNo());
        postMapper.updatePostById(postEditRequest);
    }

    @Override
    public void removePostById(Long postNo) {
        postMapper.deleteByPostNo(postNo);
    }
}
