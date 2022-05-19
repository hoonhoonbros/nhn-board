package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.domain.Post;
import com.nhnacademy.jdbc.board.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("posts/index");
        mav.addObject("posts", postService.getPosts());

        return mav;
    }

    @GetMapping("/write")
    public String writePost() {
        return "posts/write";
    }
}
