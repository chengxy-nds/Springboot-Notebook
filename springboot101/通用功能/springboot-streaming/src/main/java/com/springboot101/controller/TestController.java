package com.springboot101.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/sse")
    public String sse(Model model) {
        return "sse";
    }
}