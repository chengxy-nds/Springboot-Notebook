package com.xiaofu.webhook.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.logging.Logger;

/**
 * @Auther: 公众号：程序员小富
 * @Date: 2021/5/24 20:40
 * @Description:
 */
@Component
@Slf4j
public class HttpUtil {

    /**
     * 发送post请求
     *
     * @param url  请求的url
     * @param body json串
     * @return
     */
    public static String sendPostJsonBody(String url, String body) {
        log.debug("[HttpClientUtil][sendPostJsonBody] 入参 url={} body={}", url, body);
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
        StringEntity entity = new StringEntity(body, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        try {
            HttpClient client = httpClientBuilder.build();
            HttpResponse response = client.execute(httpPost);
            if (response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                log.debug("[HttpClientUtil][sendPostJsonBody] 结果 url={} result={}", url, result);
                return result;
            }
            log.warn("[HttpClientUtil][sendPostJsonBody] 请求失败 response={}", url, response.toString());
            return "";
        } catch (IOException ex) {
            log.error("[HttpClientUtil][sendPostJsonBody] 请求异常 ex={}", url, ex);
            return "";
        }
    }

    public static String sendGet(String url) {
        log.debug("[HttpClientUtil][sendPostJsonBody] 入参 url={} ", url);
        HttpGet httpPost = new HttpGet(url);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        try {
            HttpClient client = httpClientBuilder.build();
            HttpResponse response = client.execute(httpPost);
            if (response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                log.debug("[HttpClientUtil][sendPostJsonBody] 结果 url={} result={}", url, result);
                return result;
            }
            log.warn("[HttpClientUtil][sendPostJsonBody] 请求失败 response={}", url, response.toString());
            return "";
        } catch (IOException ex) {
            log.error("[HttpClientUtil][sendPostJsonBody] 请求异常 ex={}", url, ex);
            return "";
        }
    }
}
