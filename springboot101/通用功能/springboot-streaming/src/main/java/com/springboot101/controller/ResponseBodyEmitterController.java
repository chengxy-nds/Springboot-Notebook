package com.springboot101.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class ResponseBodyEmitterController {
    private final ExecutorService nonBlockingService = Executors.newCachedThreadPool();

    @GetMapping("bodyEmitter")
    public ResponseBodyEmitter handle() {

        // 创建一个ResponseBodyEmitter，-1代表不超时
        ResponseBodyEmitter emitter = new ResponseBodyEmitter(-1L);

        // 异步执行耗时操作
        CompletableFuture.runAsync(() -> {
            try {
                // 模拟耗时操作
                for (int i = 0; i < 10000; i++) {
                    System.out.println("bodyEmitter " + i);
                    // 发送数据
                    emitter.send("bodyEmitter " + i + " @ " + new Date() + "\n");
                    Thread.sleep(2000);
                }
                // 完成
                emitter.complete();
            } catch (Exception e) {
                // 发生异常时结束接口
                emitter.completeWithError(e);
            }
        });
        return emitter;
    }
}