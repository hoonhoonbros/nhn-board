package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import com.nhnacademy.jdbc.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("{postId}")
    public ModelAndView postDetail(@PathVariable Long postId) {
        ModelAndView mav = new ModelAndView("posts/post");
        mav.addObject("post", postService.getPost(postId));

        return mav;
    }

    @GetMapping("/new")
    public String newPost() {
        return "posts/new";
    }

    @PostMapping("/new")
    public ModelAndView doNewPost(@ModelAttribute PostNewRequest postRequest) {
        ModelAndView mav = new ModelAndView("posts/post");

        // FIXME: return type
        // mav.addObject("post", postService.newPost(postRequest));

        return mav;
    }

    @GetMapping("/edit")
    public String editPost() {
        return "posts/edit";
    }

    @PutMapping("/edit")
    public String doEditPost() {
        // TODO: Validation -> index | postDetail
        // return "posts/edit";
        return null;
    }

    @GetMapping("/delete")
    public String deletePost() {
        return "posts/delete";
    }

    @DeleteMapping("/delete")
    public String doDeletePost() {
        return null;
    }
}
