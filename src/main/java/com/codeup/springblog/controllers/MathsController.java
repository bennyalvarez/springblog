package com.codeup.springblog.controllers;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathsController {

    @GetMapping("/add/{num1}/ands/{num2}")
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/froms/{num2}")
    @ResponseBody
    public int subtract(@PathVariable int num1, @PathVariable int num2) {
        return num2 - num1;
    }

    @GetMapping("/multiply/{num1}/ands/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide/{num1}/bys/{num2}")
    @ResponseBody
    public int divide(@PathVariable int num1, @PathVariable int num2) {
        return num1 / num2;
    }


}
