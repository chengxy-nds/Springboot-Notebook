package com.chengxy.delayqueue.controller;//package com.xinzf.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping
public class RabbitController {



    @RequestMapping(value = "/rabbit", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> dirtRabbit(String type) throws IOException {

        return null;
    }
}
