package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.domain.page.MySqlPaginator;
import com.nhnacademy.jdbc.board.domain.page.Page;
import com.nhnacademy.jdbc.board.domain.page.Pageable;
import com.nhnacademy.jdbc.board.domain.post.Post;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import com.nhnacademy.jdbc.board.service.PostService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("posts/index");

        Pageable pageable = new MySqlPaginator(0, new Page(1L, 4));
        mav.addObject("pagination", pageable);
        mav.addObject("posts", postService.getPagingPosts(pageable));

        return mav;
    }

    @GetMapping("/page/{pageNo}")
    public ModelAndView index(@PathVariable Long pageNo) {
        ModelAndView mav = new ModelAndView("posts/index");
        Pageable pageable = new MySqlPaginator(0, new Page(pageNo, 4));
        mav.addObject("pagination", pageable);
        mav.addObject("posts", postService.getPagingPosts(pageable));

        return mav;
    }

    @GetMapping("/{postNo}")
    public ModelAndView postDetail(@PathVariable Long postNo) {
        ModelAndView mav = new ModelAndView("posts/post");
        mav.addObject("post", postService.getPost(postNo));

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
    public ModelAndView editPost(@PathVariable Long postNo,HttpServletRequest request) {
        ModelAndView mav = null;
        Post post = postService.getEditPost(postNo, request);

        if(Objects.isNull(post)){
            mav = new ModelAndView("redirect:/posts");
        }else{
            mav = new ModelAndView("posts/edit");
        }

        mav.addObject("postNo", postNo);
        mav.addObject("post", post);

        return mav;
    }

    @PostMapping("/{postNo}/edit")
    public String doEditPost(@ModelAttribute PostNewRequest postEditRequest, HttpServletRequest request) {
        // TODO: Validation -> index | postDetail
        postService.editPost(postEditRequest, request);
        return "redirect:/posts";
    }

    @GetMapping("/{postNo}/delete")
    public String deletePost(@PathVariable Long postNo, HttpServletRequest request) {
        postService.doDelete(postNo, request);
        return "redirect:/posts/";
    }

    @GetMapping("/reply/{postNo}")
    public ModelAndView reply(@PathVariable Long postNo) {
        ModelAndView mav = new ModelAndView("posts/reply");
        mav.addObject("postNo", postNo);

        return mav;
    }

    @PostMapping("/reply/{parentPostNo}")
    public String doReply(@ModelAttribute PostNewRequest postRequest, HttpServletRequest request) {
        postService.doReplyPost(postRequest, request);

        return "redirect:/posts";
    }
}
