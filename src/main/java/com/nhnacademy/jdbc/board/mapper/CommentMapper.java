package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.comment.Comment;
import com.nhnacademy.jdbc.board.domain.comment.CommentItem;
import com.nhnacademy.jdbc.board.domain.comment.CommentNewRequest;
import java.util.List;
import java.util.Optional;

public interface CommentMapper {
    List<CommentItem> selectComments(Long PostNo);

    void insertComment(CommentNewRequest commentRequest);

    Optional<CommentItem> selectComment(Long commentNo);

    void updateComment(CommentNewRequest commentRequest);
}
