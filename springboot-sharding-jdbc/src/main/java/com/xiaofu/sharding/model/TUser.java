package com.xiaofu.sharding.model;

import lombok.Data;

@Data
public class TUser {

    private Long userId;

    private String userName;

    private String userNameCipher;

    private String userNamePlain;

    private String mobileNo;

    private String mobileNoPlain;

    private String mobileNoCipher;
}