package com.xiaofu.douyin.controller;


import com.alibaba.fastjson.JSON;
import com.xiaofu.douyin.po.DYDto;
import com.xiaofu.douyin.po.DYResult;
import com.xiaofu.douyin.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;

@Slf4j
@Controller
public class DYController {

    public static String DOU_YIN_BASE_URL = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=";

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * @param url
     * @author xiaofu
     * @description 解析抖音无水印视频
     * @date 2020/9/15 12:43
     */
    @RequestMapping("/parseVideoUrl")
    @ResponseBody
    public String parseVideoUrl(@RequestBody String url) throws Exception {

        DYDto dyDto = new DYDto();
        try {
            url = URLDecoder.decode(url).replace("url=", "");

            /**
             * 1、短连接重定向后的 URL
             */
            String redirectUrl = CommonUtils.getLocation(url);

            /**
             * 2、拿到视频对应的 ItemId
             */
            String videoUrl = "";
            String musicUrl = "";
            String videoPic = "";

            if (!StringUtils.isEmpty(redirectUrl)) {

                /**
                 * 3、用 ItemId 拿视频的详细信息，包括无水印视频url
                 */
                String itemId = CommonUtils.matchNo(redirectUrl);

                StringBuilder sb = new StringBuilder();
                sb.append(DOU_YIN_BASE_URL).append(itemId);

                String videoResult = CommonUtils.httpGet(sb.toString());

                DYResult dyResult = JSON.parseObject(videoResult, DYResult.class);

                /**
                 * 4、无水印视频 url
                 */
                videoUrl = dyResult.getItem_list().get(0)
                        .getVideo().getPlay_addr().getUrl_list().get(0)
                        .replace("playwm", "play");
                dyDto.setVideoUrl(videoUrl);
                /**
                 * 5、音频 url
                 */
                musicUrl = dyResult.getItem_list().get(0).getMusic().getPlay_url().getUri();
                dyDto.setMusicUrl(musicUrl);
                /**
                 * 6、封面
                 */
                videoPic = dyResult.getItem_list().get(0).getVideo().getDynamic_cover().getUrl_list().get(0);
                dyDto.setVideoPic(videoPic);
            }
        } catch (Exception e) {

            log.error("去水印异常 {}", e);
        }
        return JSON.toJSONString(dyDto);
    }
}
