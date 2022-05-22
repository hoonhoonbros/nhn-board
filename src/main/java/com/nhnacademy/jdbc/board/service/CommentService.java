package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.comment.CommentItem;
import com.nhnacademy.jdbc.board.domain.comment.CommentNewRequest;
import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface CommentService {
    List<CommentItem> getCommentsInPost();

    void newComment(CommentNewRequest commentRequest, HttpServletRequest request);
}
