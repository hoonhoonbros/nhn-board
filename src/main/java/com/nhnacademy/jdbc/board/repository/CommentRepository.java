package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.comment.CommentItem;
import com.nhnacademy.jdbc.board.domain.comment.CommentNewRequest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface CommentRepository {
    List<CommentItem> findAll();

    void save(CommentNewRequest commentRequest, HttpServletRequest request);
}
