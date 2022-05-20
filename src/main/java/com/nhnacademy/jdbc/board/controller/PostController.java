package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class PostController {
    private final PostService boardService;

    public PostController(PostService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String index() {
        return "boards/index";
    }
}
