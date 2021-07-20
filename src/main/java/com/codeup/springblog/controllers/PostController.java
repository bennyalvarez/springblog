package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts() {
        return "View all posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postID(@PathVariable long id) {
        return "<h1>This views an individual post!</h1>";
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
