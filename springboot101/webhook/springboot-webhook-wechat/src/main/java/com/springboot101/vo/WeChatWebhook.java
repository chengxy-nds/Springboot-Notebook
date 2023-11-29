package com.springboot101.vo;

import java.util.List;

/**
 * @Auther: 程序员小富
 * @Date: 2021/5/19 20:56
 * @Description:
 */
public class WeChatWebhook {

    private String msgtype;

    private TextDTO text;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public TextDTO getText() {
        return text;
    }

    public void setText(TextDTO text) {
        this.text = text;
    }

    public static class TextDTO {

        private String content;

        private List<String> mentionedList;

        private List<String> mentionedMobileList;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getMentionedList() {
            return mentionedList;
        }

        public void setMentionedList(List<String> mentionedList) {
            this.mentionedList = mentionedList;
        }

        public List<String> getMentionedMobileList() {
            return mentionedMobileList;
        }

        public void setMentionedMobileList(List<String> mentionedMobileList) {
            this.mentionedMobileList = mentionedMobileList;
        }
    }
}
