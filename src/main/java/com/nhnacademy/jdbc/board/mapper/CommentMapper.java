package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.comment.CommentItem;
import com.nhnacademy.jdbc.board.domain.comment.CommentNewRequest;
import java.util.List;

public interface CommentMapper {
    List<CommentItem> selectComments();

    void insertComment(CommentNewRequest commentRequest);
}
