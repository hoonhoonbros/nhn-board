package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("posts/index");
        mav.addObject("posts", postService.getPosts());

        return mav;
    }

    @GetMapping("/new")
    public String newPost() {
        return "posts/new-post";
    }

    @GetMapping("{postId}")
    public ModelAndView doPostDetail(@PathVariable Long postId) {
        ModelAndView mav = new ModelAndView("posts/post");
         postService.getPost(postId);

        return mav;
    }
}
