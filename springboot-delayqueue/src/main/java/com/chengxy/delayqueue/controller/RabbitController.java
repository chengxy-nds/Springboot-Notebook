package com.chengxy.delayqueue.controller;//package com.xinzf.project.controller;

import com.chengxy.delayqueue.deadLetterQueue.DeadLetterSendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping
public class RabbitController {

    @Autowired
    private DeadLetterSendMessage deadLetterSendMessage;

    @RequestMapping(value = "/rabbit", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> dirtRabbit(String delayTimes) throws IOException {

        deadLetterSendMessage.send(delayTimes);

        return null;
    }
}
