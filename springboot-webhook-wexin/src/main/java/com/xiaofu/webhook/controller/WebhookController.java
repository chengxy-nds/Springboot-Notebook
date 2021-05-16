package com.xiaofu.webhook.controller;

import com.alibaba.fastjson.JSON;
import com.xiaofu.webhook.vo.GithubWebhookPullVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public String webhookGithub(@RequestBody GithubWebhookPullVo webhook) {

        log.info(JSON.toJSONString(webhook));
        //TODO 发送企业微信 post请求
        return JSON.toJSONString(webhook);
    }
}
