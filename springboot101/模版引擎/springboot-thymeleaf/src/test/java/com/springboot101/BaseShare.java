package com.springboot101;

import java.util.Date;

import com.springboot101.po.User;
import com.springboot101.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BaseShare {

    @Resource
    private UserService userService;

    @Test
    public void userServiceTest() {
        User user = new User();
        user.setName("公众号：程序员小富");
        user.setAge(0);
        user.setEmail("vx：xinzhifu521");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.insertUser(user);
    }
}
