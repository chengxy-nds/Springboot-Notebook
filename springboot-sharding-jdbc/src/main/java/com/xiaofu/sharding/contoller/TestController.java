package com.xiaofu.sharding.contoller;

import java.util.Date;

import com.xiaofu.sharding.mapper.ConfigRepository;
import com.xiaofu.sharding.model.TConfig;
import com.xiaofu.sharding.model.TUser;
import com.xiaofu.sharding.service.UserService;
import com.xiaoju.uemc.tinyid.client.utils.TinyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xinzhifu
 * @Description:
 */
@Controller
@RequestMapping
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConfigRepository configRepository;

    @GetMapping(value = "/config")
    @ResponseBody
    public String config() {

        TConfig tConfig = new TConfig();
        tConfig.setRemark("我是备注13123123123123123");
        tConfig.setCreateTime(new Date());
        tConfig.setLastModifyTime(new Date());
        configRepository.insert(tConfig);
        tConfig.setId(1293488002854133762L);
        configRepository.updateById(tConfig);
        return "success";
    }

    @GetMapping(value = "/add")
    @ResponseBody
    public String insert() {
        // 获取单个分布式自增ID
        for (long i = 0; i < 10; i++) {
            Long id = TinyId.nextId("user_primary_key");
            TUser user = new TUser();
            //user.setId(id);
            user.setUsername("小富 " + i);
            user.setPassword("123456");
            user.setShardingId(i);
            userService.addUser(user);
        }
        return "success";
    }

    @GetMapping("/users")
    public Object list() {
        return userService.getUsers();
    }
}
