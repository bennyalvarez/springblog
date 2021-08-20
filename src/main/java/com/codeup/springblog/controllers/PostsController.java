package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsController {



    @GetMapping("/the/posts")
    @ResponseBody
    public String thePosts() {

        return "There will be posts here.";
    }



}
