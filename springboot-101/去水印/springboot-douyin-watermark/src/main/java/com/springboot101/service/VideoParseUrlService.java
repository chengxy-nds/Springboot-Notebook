package com.springboot101.service;


import com.springboot101.po.ResultDto;

public interface VideoParseUrlService {

    ResultDto dyParseUrl(String redirectUrl) throws Exception;

    ResultDto hsParseUrl(String redirectUrl) throws Exception;

    ResultDto QMParseUrl(String redirectUrl) throws Exception;
}
