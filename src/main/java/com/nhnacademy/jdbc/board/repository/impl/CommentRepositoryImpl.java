package com.nhnacademy.jdbc.board.repository.impl;

import static java.lang.Long.parseLong;

import com.nhnacademy.jdbc.board.domain.comment.Comment;
import com.nhnacademy.jdbc.board.domain.comment.CommentItem;
import com.nhnacademy.jdbc.board.domain.comment.CommentNewRequest;
import com.nhnacademy.jdbc.board.domain.user.User;
import com.nhnacademy.jdbc.board.mapper.CommentMapper;
import com.nhnacademy.jdbc.board.mapper.UserMapper;
import com.nhnacademy.jdbc.board.repository.CommentRepository;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    private final UserMapper userMapper;
    private final CommentMapper commentMapper;

    @Override
    public List<CommentItem> findAll(Long postNo) {
        return commentMapper.selectComments(postNo);
    }

    @Override
    public void save(CommentNewRequest commentRequest, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        Optional<User> user = userMapper.selectUser(username);

        commentRequest.setUserNo(user.get().getUserNo());
        commentRequest.setPostNo(parseLong(request.getParameter("commentNo")));
        commentMapper.insertComment(commentRequest);
    }

    @Override
    public CommentItem findById(Long commentNo, HttpSession session) {

        String username = (String) session.getAttribute("username");
        Optional<User> user = userMapper.selectUser(username);

        CommentItem commentItem = commentMapper.selectComment(commentNo).get();
        commentItem.setUserNo(user.get().getUserNo());

        return commentItem;
    }

    @Override
    public void modifyComment(CommentNewRequest commentRequest) {
        commentMapper.updateComment(commentRequest);
    }
}
