package com.springboot101.domain;

import com.springboot101.enums.ResultCode;
import lombok.Data;


@Data
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;
    private long timestamp ;


    public ResponseResult(){
        this.timestamp = System.currentTimeMillis();
    }

    public ResponseResult(int code) {
        this.code = code;
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> resultData = new ResponseResult<>();
        resultData.setCode(ResultCode.OK.getCode());
        resultData.setMessage(ResultCode.OK.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResponseResult<T> fail(int code, String message) {
        ResponseResult<T> resultData = new ResponseResult<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }

}