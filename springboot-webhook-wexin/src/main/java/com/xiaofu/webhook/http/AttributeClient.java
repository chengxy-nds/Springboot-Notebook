package com.xiaofu.webhook.http;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.http.ForestResponse;
import com.xiaofu.webhook.vo.WeChatWebhook;

import java.util.List;


public interface AttributeClient {

    @PostRequest("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=145a516a-dd15-421f-97a3-ba3bf1479369")
    ForestResponse<String> getAttributeBatch(@Body WeChatWebhook weChatWebhook);
}
