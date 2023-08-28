package com.springboot101.controller;

import com.alibaba.fastjson.JSON;
import com.springboot101.utils.HttpUtil;
import com.springboot101.vo.GithubWebhookPullVo;
import com.springboot101.vo.WeChatWebhook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class WebhookController {

    private static final String WECHAT_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=145a516a-dd15-421f-97a3-ba3bf1479369";

    private static final String GITHUB_API = "https://api.github.com/users/";

    /**
     * @param webhook webhook
     * @Author 程序员内点事
     * @Description: github 回调
     * @Date 2021/05/19
     */
    @PostMapping("/webhook")
    public String webhookGithub(@RequestBody GithubWebhookPullVo webhook) {
        log.info("webhook 入参接收 weChatWebhook {}", JSON.toJSONString(webhook));

        // 获取仓库名和当前时间
        String name = webhook.getRepository().getName();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleFormatter.format(new Date());

        StringBuilder contentBuilder = new StringBuilder();
        if (!webhook.getCommits().isEmpty()) {
            GithubWebhookPullVo.CommitsDTO commitsDTO = webhook.getCommits().get(0);
            contentBuilder.append("提交者：[ ").append(commitsDTO.getCommitter().getName()).append(" ] \r\n")
                    .append("时间：[ ").append(now).append(" ]\n")
                    .append("向远程仓库 [ ").append(name).append(" ]推送代码 \n")
                    .append("提交详情：  \n");

            appendListContent(contentBuilder, "添加文件:  \n[\n", commitsDTO.getAdded());
            appendListContent(contentBuilder, "修改文件:  \n[\n", commitsDTO.getModified());
            appendListContent(contentBuilder, "删除文件:  \n[\n", commitsDTO.getRemoved());
        }

        String content = contentBuilder.toString();
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

    /**
     * 将列表内容追加到字符串构建器中
     *
     * @param stringBuilder 字符串构建器
     * @param prefix        前缀
     * @param list          列表内容
     */
    private void appendListContent(StringBuilder stringBuilder, String prefix, List<String> list) {
        if (!list.isEmpty()) {
            stringBuilder.append(prefix);
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append((i + 1)).append("、").append(list.get(i)).append("\n");
            }
            stringBuilder.append("] , \n");
        }
    }
}
