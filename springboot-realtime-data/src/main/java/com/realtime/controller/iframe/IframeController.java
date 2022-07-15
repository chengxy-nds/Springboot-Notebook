package com.realtime.controller.iframe;

import com.realtime.controller.sse.SseEmitterUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

@CrossOrigin("*")
@Controller
@RequestMapping("/iframe")
public class IframeController {

    private AtomicInteger count = new AtomicInteger();

    /**
     * iframe 页面
     */
    @RequestMapping("/index")
    public String sse() {
        return "iframe";
    }

    @GetMapping(path = "message")
    public void message(HttpServletResponse response) throws IOException, InterruptedException {
        while (true) {
            count.incrementAndGet();
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-cache,no-store");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print(" <script type=\"text/javascript\">\n" +
                    "parent.document.getElementById('clock').innerHTML = \"" + count.get() + "\";" +
                    "parent.document.getElementById('count').innerHTML = \"" + count.get() + "\";" +
                    "</script>");
        }
    }
}

