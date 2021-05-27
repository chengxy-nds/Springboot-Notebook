package com.xiaofu.douyin.controller;//package com.xiaofu.webhook.controller;

import com.alibaba.fastjson.JSON;
import com.xiaofu.douyin.utils.HttpUtil;
import com.xiaofu.douyin.vo.GithubWebhookPullVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebhookController {

    private static String url = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=145a516a-dd15-421f-97a3-ba3bf1479369";

    /**
     * @param webhook webhook
     * @author 程序员内点事
     * @Description: github 回调
     * @date 2021/05/19
     */
    @PostMapping("/webhook")
    public String webhookGithub(@RequestBody GithubWebhookPullVo webhook) {

        log.info("webhook 入参接收 weChatWebhook {}", JSON.toJSONString(webhook));
        //log.info("GithubWebhookPullVo {}", JSON.toJSONString(webhook));
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

        String param = " {\"msgtype\":\"text\",\"text\":{\"content\":\"chengxy-nds/Springboot-Notebook\",\"mentionedList\":[],\"mentionedMobileList\":[]}}";

//        WeChatWebhook weChatWebhook = new WeChatWebhook();
//        weChatWebhook.setMsgtype("text");
//        WeChatWebhook.TextDTO textDTO = new WeChatWebhook.TextDTO();
//        textDTO.setContent(webhook.getRepository().getFull_name());
//        textDTO.setMentionedList(new ArrayList<>());
//        textDTO.setMentionedMobileList(new ArrayList<>());
//        weChatWebhook.setText(textDTO);

        /**
         * 组装参数后向企业微信发送webhook请求
         */
        String post = HttpUtil.sendPostJsonBody(url, param);
        log.info("企业微信发送结果 post {}", post);
        return JSON.toJSONString(post);
    }
}
