package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;


    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String viewPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postID(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @PostMapping("/post/edit/{id")
    public String editPost(@PathVariable long id, Model model) {
        Post post = postDao.getById(id);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id, Model model) {
        postDao.delete(postDao.getById(id));
        return "redirect:/posts/";
    }

    //When you visit the URL you will see the form to create a post
    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm() {
        return "<h1>This views the form for creating a post!</h1>";
    }

    //when you submit the form on the /posts/create page,
    //the info will be posted to the same URL
//    @GetMapping("/posts/create")
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    //alt way
//    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "<h1>This creates a new post!</h1>";
    }

}