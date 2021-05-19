package com.xiaofu.webhook.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: 程序员内点事
 * @Date: 2021/5/19 20:56
 * @Description:
 */
@NoArgsConstructor
@Data
public class WeChatWebhook {

    private String msgtype;

    private TextDTO text;

    @NoArgsConstructor
    @Data
    public static class TextDTO {

        private String content;

        private List<String> mentionedList;

        private List<String> mentionedMobileList;
    }
}
