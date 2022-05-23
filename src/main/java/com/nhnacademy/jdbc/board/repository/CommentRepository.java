package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.comment.Comment;
import com.nhnacademy.jdbc.board.domain.comment.CommentItem;
import com.nhnacademy.jdbc.board.domain.comment.CommentNewRequest;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface CommentRepository {
    List<CommentItem> findAll(Long postNo);

    void save(CommentNewRequest commentRequest, HttpServletRequest request);

    CommentItem findById(Long commentNo, HttpSession session);

    void modifyComment(CommentNewRequest commentRequest);
}
