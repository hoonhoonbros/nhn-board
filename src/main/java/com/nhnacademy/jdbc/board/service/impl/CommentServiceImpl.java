package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.comment.CommentItem;
import com.nhnacademy.jdbc.board.domain.comment.CommentNewRequest;
import com.nhnacademy.jdbc.board.repository.CommentRepository;
import com.nhnacademy.jdbc.board.service.CommentService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<CommentItem> getCommentsInPost() {
        return commentRepository.findAll();
    }

    @Override
    public void newComment(CommentNewRequest commentRequest, HttpServletRequest request) {
        commentRepository.save(commentRequest, request);
    }
}
