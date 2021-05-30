package com.xiaofu.webhook.controller;//package com.xiaofu.webhook.controller;

import com.alibaba.fastjson.JSON;
import com.xiaofu.webhook.utils.HttpUtil;
import com.xiaofu.webhook.vo.GithubUser;
import com.xiaofu.webhook.vo.GithubWebhookPullVo;
import com.xiaofu.webhook.vo.WeChatWebhook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.ArrayUtils;
import org.thymeleaf.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Slf4j
@RestController
public class WebhookController {


    private static String WECHAT_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=145a516a-dd15-421f-97a3-ba3bf1479369";

    private static String GITHUB_API = "https://api.github.com/users/";


    /**
     * @param webhook webhook
     * @author 程序员内点事
     * @Description: github 回调
     * @date 2021/05/19
     */
    @PostMapping("/webhook")
    public String webhookGithub(@RequestBody GithubWebhookPullVo webhook) {

        log.info("webhook 入参接收 weChatWebhook {}", JSON.toJSONString(webhook));
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

        // 仓库名
        String name = webhook.getRepository().getName();

        // 拥有者
        String owner = webhook.getRepository().getOwner().getLogin();
        GithubUser ownerUser = JSON.parseObject(HttpUtil.sendGet(GITHUB_API + owner), GithubUser.class);

        // 提交者
        String sender = webhook.getSender().getLogin();
        GithubUser senderUser = JSON.parseObject(HttpUtil.sendGet(GITHUB_API + sender), GithubUser.class);

        StringBuffer sb = new StringBuffer();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String now = simpleFormatter.format(new Date());
        sb.append("提交者：[" + senderUser.getName() + "]");
        sb.append("于：" + now);
        sb.append("向作者：[" + ownerUser.getName() + "]的，远程仓库" + name + "提交代码");

        WeChatWebhook weChatWebhook = new WeChatWebhook();
        weChatWebhook.setMsgtype("text");
        WeChatWebhook.TextDTO textDTO = new WeChatWebhook.TextDTO();
        textDTO.setContent(sb.toString());
        textDTO.setMentionedList(Arrays.asList("@all"));
        textDTO.setMentionedMobileList(Arrays.asList("@all"));
        weChatWebhook.setText(textDTO);

        /**
         * 组装参数后向企业微信发送webhook请求
         */
        log.info("企业微信发送参数 {}", JSON.toJSONString(weChatWebhook));
        String post = HttpUtil.sendPostJsonBody(WECHAT_URL, JSON.toJSONString(weChatWebhook));
        log.info("企业微信发送结果 post {}", post);
        return JSON.toJSONString(post);
    }
}
