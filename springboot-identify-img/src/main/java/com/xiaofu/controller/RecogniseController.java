package com.xiaofu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xiaofu 识别图片
 * @Description:
 */
@Controller
@RequestMapping
public class RecogniseController {


    @GetMapping(value = "/recogniseImg")
    @ResponseBody
    public String recogniseImg() {

        return null;
    }
}