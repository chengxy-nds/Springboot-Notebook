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
import java.util.List;
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
        // 仓库名
        String name = webhook.getRepository().getName();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleFormatter.format(new Date());
        String content = "";
        if (webhook.getCommits().size() > 0) {
            GithubWebhookPullVo.CommitsDTO commitsDTO = webhook.getCommits().get(0);
            content += "提交者：[ " + commitsDTO.getCommitter().getName() + " ] \r\n" +
                    "时间：[ " + now + " ]\n" +
                    "向" + "远程仓库 [ " + name + " ]推送代码 \n" +
                    "提交详情：  \n";

            List<String> addeds = commitsDTO.getAdded();
            if (addeds.size() > 0) {
                content += "添加文件:  \n[\n";
                for (int i = 0; i < addeds.size(); i++) {
                    content += (i + 1) + "、" + addeds.get(i) + "\n";
                }
                content += "] , \n";
            }
            List<String> modifieds = commitsDTO.getModified();
            if (modifieds.size() > 0) {
                content += "修改文件:  \n[\n";
                for (int i = 0; i < modifieds.size(); i++) {
                    content += (i + 1) + "、" + modifieds.get(i) + "\n";
                }
                content += "] , \n";
            }
            List<String> removeds = commitsDTO.getRemoved();
            if (removeds.size() > 0) {
                content += "删除文件:  \n[\n";
                for (int i = 0; i < removeds.size(); i++) {
                    content += (i + 1) + "、" + removeds.get(i) + "\n";
                }
                content += "]";
            }
        }
        log.info(content);
        WeChatWebhook weChatWebhook = new WeChatWebhook();
        weChatWebhook.setMsgtype("text");
        WeChatWebhook.TextDTO textDTO = new WeChatWebhook.TextDTO();
        textDTO.setContent(content);
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
