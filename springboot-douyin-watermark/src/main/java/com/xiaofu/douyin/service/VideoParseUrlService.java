package com.xiaofu.douyin.service;


import com.xiaofu.douyin.po.ResultDto;

public interface VideoParseUrlService {

    ResultDto dyParseUrl(String redirectUrl) throws Exception;

    ResultDto hsParseUrl(String redirectUrl) throws Exception;

    ResultDto QMParseUrl(String redirectUrl) throws Exception;
}
