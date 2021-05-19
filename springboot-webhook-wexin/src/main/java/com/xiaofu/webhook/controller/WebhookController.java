package com.xiaofu.webhook.controller;

import com.alibaba.fastjson.JSON;
import com.dtflys.forest.http.ForestResponse;
import com.xiaofu.webhook.http.AttributeClient;
import com.xiaofu.webhook.vo.GithubWebhookPullVo;
import com.xiaofu.webhook.vo.WeChatWebhook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebhookController {

    @Autowired
    private AttributeClient attributeClient;

    /**
     * @param webhook webhook
     * @author 程序员内点事
     * @Description: github 回调
     * @date 2021/05/19
     */
    @PostMapping("/webhook")
    public String webhookGithub(@RequestBody GithubWebhookPullVo webhook) {


        /**
         * {
         *     "msgtype": "text",
         *     "text": {
         *         "content": "广州今日天气：29度，大部分多云，降雨概率：60%",
         *         "mentioned_list":["wangqing","@all"],
         *         "mentioned_mobile_list":["13800001111","@all"]
         *     }
         * }
         */

        WeChatWebhook weChatWebhook = new WeChatWebhook();

        /**
         * 组装参数后向企业微信发送webhook请求
         */
        ForestResponse<String> attributeBatch = attributeClient.getAttributeBatch(weChatWebhook);

        return JSON.toJSONString(webhook);
    }
}
