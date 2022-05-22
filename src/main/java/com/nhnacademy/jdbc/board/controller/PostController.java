package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.domain.page.MySqlPaginator;
import com.nhnacademy.jdbc.board.domain.page.Page;
import com.nhnacademy.jdbc.board.domain.page.Pageable;
import com.nhnacademy.jdbc.board.domain.post.PostNewRequest;
import com.nhnacademy.jdbc.board.service.PostService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public String editPost() {
        return "posts/edit";
    }

    @PutMapping("/{postNo}/edit")
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

    @GetMapping("/reply/{parentPostNo}")
    public ModelAndView reply(@PathVariable Long parentPostNo) {
        ModelAndView mav = new ModelAndView("posts/reply");
        mav.addObject(parentPostNo);

        return mav;
    }

    @PostMapping("/reply/{parentPostNo}")
    public ModelAndView doReply(@ModelAttribute PostNewRequest postRequest) {
        ModelAndView mav = new ModelAndView("posts/post");
        postService.doReplyPost(postRequest);
        // mav.addObject("post", );

        return mav;
    }
}
