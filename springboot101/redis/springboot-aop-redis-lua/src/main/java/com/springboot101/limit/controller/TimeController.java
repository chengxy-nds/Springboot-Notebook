package com.springboot101.limit.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Controller
public class TimeController {

    @GetMapping("/timeTest")
    public String timeTest(Model model) {
        OrderInfo order = new OrderInfo();
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(new Date());
        model.addAttribute("order",order);
        System.out.println(JSON.toJSONString(order));
        return "index";
    }

    @GetMapping("/timeTest1")
    @ResponseBody
    public OrderInfo timeTest1() {
        OrderInfo order = new OrderInfo();
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(new Date());
        return order;
    }

    public class OrderInfo implements Serializable{

        //@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
        private LocalDateTime createTime;

        //@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
        private Date updateTime;

        public LocalDateTime getCreateTime() {
            return createTime;
        }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }
    }
}