package com.xiaofu.douyin.controller;


import com.alibaba.fastjson.JSON;
import com.xiaofu.douyin.po.ResultDto;
import com.xiaofu.douyin.service.VideoParseUrlService;
import com.xiaofu.douyin.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;


/**
 * @author xiaofu-公众号：程序员内点事
 * @description 抖音无水印视频下载
 * @date 2020/9/15 18:44
 */
@Slf4j
@Controller("/order")
public class DYController {

    @Autowired
    private VideoParseUrlService videoParseUrlService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * @param url
     * @author xiaofu
     * @description 解析无水印视频url
     * @date 2020/9/15 12:43
     */
    @RequestMapping("/parseVideoUrl")
    @ResponseBody
    public String parseVideoUrl(@RequestBody String url) throws Exception {

        log.info("待解析URL :{}", url);

        ResultDto resultDto = new ResultDto();
        try {
            url = URLDecoder.decode(url).replace("url=", "");

            if (url.contains(CommonUtils.HUO_SHAN_DOMAIN)) {

                resultDto = videoParseUrlService.hsParseUrl(url);

            } else if (url.contains(CommonUtils.DOU_YIN_DOMAIN)) {

                resultDto = videoParseUrlService.dyParseUrl(url);
            }
        } catch (Exception e) {

            log.error("去水印异常 {}", e);
        }
        return JSON.toJSONString(resultDto);
    }
}