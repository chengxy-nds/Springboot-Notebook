package com.xiaofu.sharding.contoller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaofu.sharding.mapper.ConfigRepository;
import com.xiaofu.sharding.mapper.OrderItemRepository;
import com.xiaofu.sharding.mapper.OrderRepository;
import com.xiaofu.sharding.mapper.UserRepository;
import com.xiaofu.sharding.model.TConfig;
import com.xiaofu.sharding.model.TOrder;
import com.xiaofu.sharding.model.TOrderDto;
import com.xiaofu.sharding.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/insertUser")
    @ResponseBody
    public String insertUser(HttpServletRequest request) {

        TUser user = new TUser();
        user.setUserId(100L);
        user.setUserName("程序员内点事");
        user.setMobileNo("1316656565");
        userRepository.insert(user);


        List<TUser> tUsers = userRepository.selectList(null);
        return JSON.toJSONString(tUsers);
    }
}
