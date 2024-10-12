package com.springboot101.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
public class StreamingResponseBodyController {

    @GetMapping("/streamingResponse")
    public ResponseEntity<StreamingResponseBody> handleRbe() {

        StreamingResponseBody stream = out -> {
            String message = "streamingResponse";
            for (int i = 0; i < 1000; i++) {
                try {
                    out.write(((message + i) + "\r\n").getBytes());
                    out.write("\r\n".getBytes());
                    //调用一次flush就会像前端写入一次数据
                    out.flush();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(stream);
    }
}