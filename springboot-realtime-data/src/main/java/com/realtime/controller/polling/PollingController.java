package com.realtime.controller.polling;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.context.request.async.DeferredResult;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import static com.realtime.controller.polling.AsyncConfig.TIME_OUT;

@CrossOrigin("*")
@Controller
@RequestMapping("/polling")
public class PollingController {

    // 存放监听某个Id的长轮询集合
    public static Multimap<String, DeferredResult<String>> watchRequests = Multimaps.synchronizedMultimap(HashMultimap.create());

    @RequestMapping("/index")
    public String sse() {
        return "polling";
    }

    /**
     * 公众号：程序员小富
     * 设置监听
     */
    @GetMapping(path = "watch/{id}")
    @ResponseBody
    public DeferredResult<String> watch(@PathVariable String id) {

        DeferredResult<String> deferredResult = new DeferredResult<>(TIME_OUT);
        try {
            // 异步请求完成时移除 key，防止内存溢出
            deferredResult.onCompletion(() -> {
                watchRequests.remove(id, deferredResult);
            });
            watchRequests.put(id, deferredResult);
            return deferredResult;
        } catch (AsyncRequestTimeoutException e) {
            DeferredResult<String> stringDeferredResult = new DeferredResult<>();
            stringDeferredResult.setResult("超时了");
            return stringDeferredResult;
        }
    }

    /**
     * 公众号：程序员小富
     * 变更数据
     */
    @GetMapping(path = "publish/{id}")
    @ResponseBody
    public String publish(@PathVariable String id) {

        if (watchRequests.containsKey(id)) {
            Collection<DeferredResult<String>> deferredResults = watchRequests.get(id);
            for (DeferredResult<String> deferredResult : deferredResults) {
                deferredResult.setResult("我更新了" + DateUtil.formatDate(new Date()));
            }
        }
        return "success";
    }
}

