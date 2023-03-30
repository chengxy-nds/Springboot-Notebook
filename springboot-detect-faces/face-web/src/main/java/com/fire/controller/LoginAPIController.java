package com.fire.controller;

import com.fire.base.Resp;
import com.fire.service.FaceEngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiaofu
 * @Description:
 * @date 2021/08/19
 */
@Slf4j
@Validated
@Controller
@RequestMapping("/login")
public class LoginAPIController {

    @Resource
    private FaceEngineService faceEngineService;

    @RequestMapping("/detectFaces")
    @ResponseBody
    public Resp faceDiscern(@RequestParam("file") String file) {
        return Resp.ok(faceEngineService.detectFaces(file));
    }

    @RequestMapping("/face")
    public String face() {
        return "face";
    }

    @RequestMapping("/index1")
    public String index1() {
        return "index1";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "index2";
    }
}
