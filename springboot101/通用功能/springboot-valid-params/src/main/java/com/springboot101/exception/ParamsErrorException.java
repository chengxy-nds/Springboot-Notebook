package com.springboot101.exception;


public class ParamsErrorException extends RuntimeException {

    private final int code;

    public ParamsErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}