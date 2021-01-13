package com.xiaofu.attack.contoller;

import com.alibaba.fastjson.JSON;
import com.xiaofu.attack.mapper.UserRepository;
import com.xiaofu.attack.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 正常登录
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody TUser tUser) {

        TUser login = userRepository.login(tUser);

        return JSON.toJSONString(login);
    }

    /**
     * SQL 注入登录
     */
    @PostMapping(value = "/attackLogin")
    @ResponseBody
    public String attackLogin(@RequestBody TUser tUser) {

        TUser login = userRepository.attackLogin(tUser);

        return JSON.toJSONString(login);
    }
}
