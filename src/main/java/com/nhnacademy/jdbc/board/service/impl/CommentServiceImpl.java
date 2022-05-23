package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.comment.Comment;
import com.nhnacademy.jdbc.board.domain.comment.CommentItem;
import com.nhnacademy.jdbc.board.domain.comment.CommentNewRequest;
import com.nhnacademy.jdbc.board.repository.CommentRepository;
import com.nhnacademy.jdbc.board.service.CommentService;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<CommentItem> getCommentsInPost(Long postNo) {
        return commentRepository.findAll(postNo);
    }

    @Override
    public void newComment(CommentNewRequest commentRequest, HttpServletRequest request) {
        commentRepository.save(commentRequest, request);
    }

    @Override
    public CommentItem getComment(Long commentNo, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        CommentItem commentItem = commentRepository.findById(commentNo, session);

        if(Objects.isNull(session)){
            return null;
        }

        String userName = (String) session.getAttribute("username");

        if(!Objects.equals(userName, commentItem.getAuthor())){
            if(Objects.equals(userName, "admin")){
                return commentItem;
            }
            return null;
        }

        return commentItem;
    }

    @Override
    public void editComment(CommentNewRequest commentRequest) {
        commentRepository.modifyComment(commentRequest);
    }
}
