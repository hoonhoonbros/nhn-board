package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.comment.Comment;
import com.nhnacademy.jdbc.board.domain.comment.CommentItem;
import com.nhnacademy.jdbc.board.domain.comment.CommentNewRequest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface CommentService {
    List<CommentItem> getCommentsInPost(Long postNo);

    void newComment(CommentNewRequest commentRequest, HttpServletRequest request);

    CommentItem getComment(Long commentNo, HttpServletRequest request);

    void editComment(CommentNewRequest commentRequest);
}
