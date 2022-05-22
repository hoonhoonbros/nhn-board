package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import com.nhnacademy.jdbc.board.service.PostService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("posts/index");
        mav.addObject("posts", postService.getAllPosts());

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
    public String doNewPost(@ModelAttribute PostNewRequest postRequest,
                            HttpServletRequest request) {

        postService.newPost(postRequest, request);

        return "redirect:/posts";
    }

    @GetMapping("/{postNo}/edit")
    public ModelAndView editPost(@PathVariable Long postNo) {
        ModelAndView mav = new ModelAndView("posts/edit");
        mav.addObject("postNo", postNo);
        mav.addObject("post", postService.getPost(postNo));

        return mav;
    }

    // @PutMapping("/{postNo}/edit")
    // public ModelAndView doEditPost(@RequestParam("title")String title, @RequestParam("content")String content) {
    //     // TODO: Validation -> index | postDetail
    //     ModelAndView mav = new ModelAndView("posts/post");
    //     mav.addObject("post", postService.edit(title, content));
    //     // return "posts/edit";
    //     return null;
    // }

    @PostMapping("/{postNo}/edit")
    public ModelAndView doEditPost(@ModelAttribute PostNewRequest postEditRequest) {
        // TODO: Validation -> index | postDetail
        ModelAndView mav = new ModelAndView("posts/index");
        mav.addObject("post", postService.editPost(postEditRequest));
        // return "posts/edit";
        return mav;
    }

    @GetMapping("/delete")
    public String deletePost() {
        return "posts/delete";
    }

    @DeleteMapping("/delete")
    public String doDeletePost() {
        return null;
    }

    @GetMapping("/reply/{postNo}")
    public ModelAndView reply(@PathVariable Long postNo){
        ModelAndView mav = new ModelAndView("posts/reply");
        mav.addObject("postNo", postNo);

        return mav;
    }

    @PostMapping("/reply/{parentPostNo}")
    public String doReply(@ModelAttribute PostNewRequest postRequest, HttpServletRequest request){
        postService.doReplyPost(postRequest, request);

        return "posts/index";
    }
}
