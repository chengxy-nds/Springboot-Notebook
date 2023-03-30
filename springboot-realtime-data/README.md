
**大家好，我是小富～**

我有一个朋友～

做了一个小破站，现在要实现一个站内信web消息推送的功能，对，就是下图这个小红点，一个很常用的功能。

![](https://files.mdnice.com/user/303/b713bf50-6512-464e-b684-29589f8677b9.png)

不过他还没想好用什么方式做，这里我帮他整理了一下几种实现方案。

![](https://files.mdnice.com/user/303/130a09a0-70fa-4991-81a7-1f7ed0dfbfd9.png)

### 什么是消息推送（push）

消息推送(`push`)通常是指网站的运营工作等人员，通过某种工具对用户当前网页或移动设备APP进行的主动消息推送。

推送的场景比较多，比如有人关注我的公众号，这时我就会收到一条推送消息，以此来吸引我点击打开应用，消息推送一般又分为`web端消息推送`和`移动端消息推送`。

![](https://img-blog.csdnimg.cn/d5b8617c37fd489896603d562f8a98c1.png)

上边的这种属于移动端消息推送，web端消息推送常见的诸如站内信、未读邮件数量、监控报警数量等，应用的也非常广泛。


![](https://img-blog.csdnimg.cn/img_convert/15ead5d6e8b7afcfdccbcec02a181301.png)


在具体实现之前，咱们再来分析一下前边的需求，其实功能很简单，只要触发某个事件（主动分享了资源或者后台主动推送消息），web页面的通知小红点就会实时的`+1`就可以了。

消息推送无非是推（`push`）和拉（`pull`）两种形式。通常在服务端会有若干张消息推送表，用来记录用户触发不同事件所推送不同类型的消息，前端主动查询（拉）或者被动接收（推）用户所有未读的消息数。

![](https://img-blog.csdnimg.cn/img_convert/198443b7c2f609da3bdf5b507bca0918.png)


### 短轮询

轮询(`polling`)应该是实现消息推送方案中最简单的一种，这里我们暂且将轮询分为`短轮询`和`长轮询`。

短轮询很好理解，指定的时间间隔，由浏览器向服务器发出`HTTP`请求，服务器实时返回未读消息数据给客户端，浏览器再做渲染显示。


![](https://files.mdnice.com/user/303/65699788-5f1c-4f9d-acea-9187a1f25b62.png)


一个简单的JS定时器就可以搞定，每秒钟请求一次未读消息数接口，返回的数据展示即可。

```
setInterval(() => {
  // 方法请求
  messageCount().then((res) => {
      if (res.code === 200) {
          this.messageCount = res.data
      }
  })
}, 1000);
```


是我们期望的效果，用短轮询实现固然简单，缺点也是显而易见，由于推送数据并不会频繁变更，无论后端此时是否有新的消息产生，客户端都会进行请求，势必会对服务端造成很大压力，浪费带宽和服务器资源。

![](https://files.mdnice.com/user/303/5738e243-a0fb-41fd-83fb-59f868b249b3.gif)


### 长轮询

长轮询是对上边短轮询的一种改进版本，之前我在[Nacos配置中心交互模型是 push 还是 pull ？（原理+源码分析）](https://mp.weixin.qq.com/s/94ftESkDoZI9gAGflLiGwg)一文中就详细介绍过，`Nacos`的配置中心就是基于长轮询方式实现的，可以说用的很溜了，感兴趣的可以了解下。


短轮询的弊端是有太多无效的请求，那么如果控制住请求的频率是不是就行了？

我们按照`Nacos`的思路简单实现一下，对于客户端发送的请求，服务端不再立即响应，

![](https://files.mdnice.com/user/303/e60a84bc-029a-4d1b-b02d-49f0d9e98689.png)








https://mp.weixin.qq.com/s/94ftESkDoZI9gAGflLiGwg

https://blog.csdn.net/xingxinggua9620/article/details/113565073

https://wenku.baidu.com/view/d4cb42deadf8941ea76e58fafab069dc502247a5.html

### iframe流

iframe流就是在页面中插入一个隐藏的`<iframe>`标签，通过在`src`中请求消息数量API接口，由此在服务端和客户端之间创建一条长连接，服务端持续向`iframe`传输数据。

> 传输的数据通常是`HTML`、或是内嵌的`javascript`脚本，来达到实时更新页面。

![](https://files.mdnice.com/user/303/b2b77c52-d0fe-4f7c-a4cf-3b9f5ac31938.png)

这种方式实现简单，前端只要一个`<iframe>`标签搞定了

```
<iframe src="/iframe/message" style="display:none"></iframe>
```

服务端直接组装html、js脚本数据向`response`写入就行了

```
@Controller
@RequestMapping("/iframe")
public class IframeController {
    @GetMapping(path = "message")
    public void message(HttpServletResponse response) throws IOException, InterruptedException {
        while (true) {
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
```

但我个人不推荐，因为它在浏览器上会显示请求未加载完，图标会不停旋转，简直是强迫症杀手。

![](https://files.mdnice.com/user/303/c4887635-4e93-40a8-a929-5d1d8476f5ea.gif)

### SSE (推荐的方式)

很多人可能不知道，服务端向客户端推送消息，其实除了可以用`WebSocket`这种耳熟能详的机制外，还有一种服务器发送事件(`Server-sent events`)，简称`SSE`。


`SSE`它是基于`HTTP`协议的，我们知道一般意义上的HTTP协议是无法做到服务端主动向客户端推送消息的，但SSE是个例外，它变换了一种思路。

![](https://files.mdnice.com/user/303/785e576a-122c-4f7f-b494-f1e317fdd290.png)


SSE在服务器和客户端之间打开一个单向通道，服务端响应的不再是一次性的数据包而是`text/event-stream`类型的数据流信息，在有数据变更时从服务器流式传输到客户端。

整体的实现思路有点类似于在线视频播放，视频流会连续不断的推送到浏览器，你也可以理解成，客户端在完成一次用时很长（网络不畅）的下载。

![](https://files.mdnice.com/user/303/e51fb2c5-a713-450e-bdc3-98cee87b32e7.png)

`SSE`与`WebSocket`作用相似，都可以建立服务端与浏览器之间的通信，实现服务端向客户端推送消息，但还是有些许不同：

- SSE 是基于HTTP协议的，它们不需要特殊的协议或服务器实现即可工作；`WebSocket`需单独服务器来处理协议。
- SSE 单向通信，只能由服务端向客户端单向通信；webSocket全双工通信，即通信的双方可以同时发送和接受信息。
- SSE 实现简单开发成本低，无需引入其他组件；WebSocket传输数据需做二次解析，开发门槛高一些。
- SSE 默认支持断线重连；WebSocket则需要自己实现。
- SSE 只能传送文本消息，二进制数据需要经过编码后传送；WebSocket默认支持传送二进制数据。

**SSE与WebSocket该如何选择？**

>技术并没有好坏之分，只有哪个更合适某个场景


SSE 一直被隐藏起来的一个原因是因为后来的 API（如WebSockets ）提供了更丰富的协议来执行双向、全双工通信。对于游戏、消息传递应用程序以及需要双向近乎实时更新的情况，拥有双向通道更具吸引力。但是，在某些情况下，不需要从客户端发送数据。您只需要一些服务器操作的更新。一些例子是朋友的状态更新、股票行情、新闻提要或其他自动数据推送机制（例如更新客户端 Web SQL 数据库或 IndexedDB 对象存储）。如果您需要将数据发送到服务器，XMLHttpRequest永远是朋友。

SSE 通过传统的 HTTP 发送。这意味着它们不需要特殊的协议或服务器实现即可工作。另一方面，WebSockets 需要全双工连接和新的 Web Socket 服务器来处理协议。此外，Server-Sent Events 具有 WebSockets 在设计上缺乏的多种功能，例如自动重新连接、事件 ID和发送任意事件的能力。

```javascript
<script>
    let source = null;
    let userId = 7777
    if (window.EventSource) {
        // 建立连接
        source = new EventSource('http://localhost:7777/sse/sub/'+userId);
        setMessageInnerHTML("连接用户=" + userId);
        /**
         * 连接一旦建立，就会触发open事件
         * 另一种写法：source.onopen = function (event) {}
         */
        source.addEventListener('open', function (e) {
            setMessageInnerHTML("建立连接。。。");
        }, false);
        /**
         * 客户端收到服务器发来的数据
         * 另一种写法：source.onmessage = function (event) {}
         */
        source.addEventListener('message', function (e) {
            setMessageInnerHTML(e.data);
        });
        /**
         * 如果发生通信错误（比如连接中断），就会触发error事件
         * 或者：
         * 另一种写法：source.onerror = function (event) {}
         */
        source.addEventListener('error', function (e) {
            if (e.readyState === EventSource.CLOSED) {
                setMessageInnerHTML("连接关闭");
            } else {
                console.log(e);
            }
        }, false);
    } else {
        setMessageInnerHTML("你的浏览器不支持SSE");
    }
    // 监听窗口关闭事件，主动去关闭sse连接，如果服务端设置永不过期，浏览器关闭后手动清理服务端数据
    window.onbeforeunload = function () {
        closeSse();
    };
    // 关闭Sse连接
    function closeSse() {
        source.close();
        const httpRequest = new XMLHttpRequest();
        httpRequest.open('GET', 'http://localhost:7788/sse/close/' + userId, true);
        httpRequest.send();
        console.log("close");
    }
    // 将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        $("#arrivedDiv").append("<br/>"+innerHTML);
        var count = $("#count").text();
        count = Number(count) + 1;
        $("#count").text(count);
    }
</script>
```

我们模拟服务端推送消息，看下客户端收到了消息，和我们预期的效果一致。
![](https://files.mdnice.com/user/303/9d79d86d-c84d-43b1-aebc-53ecf384f7b8.gif)


SSE不支持 IE 浏览器，其他主流浏览器兼容性做的还不错。
![](https://files.mdnice.com/user/303/27c6fd5d-a4c0-4a80-bb81-0aacd1c89f03.png)



### MQTT

### websocket

http://demos.workerman.net/web-sender/


### MQ

### goEasy

https://blog.csdn.net/windrainpy/article/details/105026780

https://www.kancloud.cn/fundebug/fundebug-blog/994905

https://www.cxyzjd.com/article/momolela/53113598

https://www.ruanyifeng.com/blog/2017/05/server-sent_events.html

https://www.cnblogs.com/hzb462606/p/15422600.html

https://developer.aliyun.com/article/693576

https://baijiahao.baidu.com/s?id=1710213737252683265&wfr=spider&for=pc

https://blog.csdn.net/wuliu_forever/article/details/88883609

https://blog.csdn.net/hj7jay/article/details/89761047