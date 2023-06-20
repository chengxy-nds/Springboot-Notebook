package com.springboot101.confirm.controller;

import com.springboot101.confirm.sender.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Controller
@RequestMapping
public class TestController {

    @Autowired
    private SendMessage sendMessage;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String test() {

        //sendMessage.sendMessage("", "confirm_test_queue", "0" );


        for (int i = 0; i < 5; i++) {

            sendMessage.sendMessage("", "confirm_test_queue",  "发送者消息");
        }

        return "success";
    }
}
