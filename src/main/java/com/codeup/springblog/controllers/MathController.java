package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    //add method
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2 ) + "!";
    }

    //alt add method
    @GetMapping("/add2/{num1}/and/{num2}")
    @ResponseBody
    public String addition(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1 + num2 );
    }

    //subtract
    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " - " + num2 + " = " + (num1-num2) + "!";
    }

    //alt subtract
    @GetMapping("/subtract2/{num1}/and/{num2}")
    @ResponseBody
    public String subtractNum(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1-num2);
    }

    //multiply
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " * " + num2 + " = " + (num1 * num2) + "!";
    }

    //multiply alt
    @GetMapping("/multiply2/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyNum(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1 * num2);
    }


    //divide
    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " / " + num2 + " = " + (num1 / num2) + "!";
    }

    @GetMapping("/divide2/{num1}/and/{num2}")
    @ResponseBody
    public String divideNum(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1 / num2);
    }
}
