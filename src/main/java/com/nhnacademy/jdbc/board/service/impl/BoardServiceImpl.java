package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.repository.BoardRepository;
import com.nhnacademy.jdbc.board.service.BoardService;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
}
