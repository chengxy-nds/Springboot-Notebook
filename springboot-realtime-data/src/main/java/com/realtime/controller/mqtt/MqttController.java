package com.realtime.controller.mqtt;


import com.realtime.producer.IotMqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xiaofu
 * @Description:
 * @date 2020/6/8 18:26
 */
@CrossOrigin("*")
@Controller
@RequestMapping("mqtt")
public class MqttController {

    @Autowired
    private IotMqttGateway mqttGateway;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/sendMessage")
    @ResponseBody
    public String sendMqtt(@RequestParam(value = "topic") String topic, @RequestParam(value = "message") String message) {
        mqttGateway.sendMessage2Mqtt(message, topic);
        return "SUCCESS";
    }


}
