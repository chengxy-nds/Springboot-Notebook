package com.springboot101.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    @GetMapping("/example")
    public ModelAndView example(ModelAndView modelAndView) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        modelAndView.setViewName("fruits");
        modelAndView.addObject("fruits", fruits);
        return modelAndView;
    }

    @GetMapping("/example1")
    public String example1(Model model) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        model.addAttribute("fruits", fruits);
        return "fruits.html";
    }

    @GetMapping("/example2")
    public String example2(Model model) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        model.addAttribute("fruits", fruits);
        return "fruits";
    }
}