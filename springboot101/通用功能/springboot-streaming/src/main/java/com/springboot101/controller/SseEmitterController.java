package com.springboot101.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
public class SseEmitterController {

    private static final Map<String, SseEmitter> EMITTER_MAP = new ConcurrentHashMap<>();

    @GetMapping("/subSseEmitter/{userId}")
    public SseEmitter sseEmitter(@PathVariable String userId) {
        log.info("sseEmitter: {}", userId);
        SseEmitter emitterTmp = new SseEmitter(-1L);
        EMITTER_MAP.put(userId, emitterTmp);
        CompletableFuture.runAsync(() -> {
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data("sseEmitter" + userId + " @ " + LocalTime.now())
                        .id(String.valueOf(userId))
                        .name("sseEmitter");
                emitterTmp.send(event);
            } catch (Exception ex) {
                emitterTmp.completeWithError(ex);
            }
        });
        return emitterTmp;
    }

    @GetMapping("/sendSseMsg/{userId}")
    public void sseEmitter(@PathVariable String userId, String msg) throws IOException {
        SseEmitter sseEmitter = EMITTER_MAP.get(userId);
        if (sseEmitter == null) {
            return;
        }
        sseEmitter.send(msg);
    }
//    @GetMapping("/sseEmitter/{userId}")
//    public SseEmitter sseEmitter(@PathVariable String userId) {
//
//        CompletableFuture.runAsync(() -> {
//            try {
//                for (int i = 0; i < 10000; i++) {
//                    SseEmitter.SseEventBuilder event = SseEmitter.event()
//                            .data("sseEmitter" + i + " @ " + LocalTime.now())
//                            .id(String.valueOf(i))
//                            .name("sseEmitter");
//                    emitter.send(event);
//                    Thread.sleep(1000);
//                }
//                emitter.complete();
//            } catch (Exception ex) {
//                emitter.completeWithError(ex);
//            }
//        });
//        return emitter;
//    }
}