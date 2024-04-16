package com.springboot101.enums;


public enum ResultCode {

    /**
     * 操作成功
     */
    OK(100, "操作成功"),

    /**
     * 操作失败
     */
    OPS_ERROR(-1, "操作失败"),

    /**
     * 参数校验不通过
     */
    PARAMETER_ERROR(204, "参数校验不通过"),

    /**
     * 服务异常
     */
    SYSTEM_ERROR(500, "系统异常，请稍后重试");

    /**
     * 自定义状态码
     **/
    private final int code;

    /**
     * 自定义描述
     **/
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}