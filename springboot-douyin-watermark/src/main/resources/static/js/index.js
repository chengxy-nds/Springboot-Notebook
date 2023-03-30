layui.use(['layer', 'element'], function () {
    var $ = layui.jquery;
})

// 复制链接
function copy(felu) {
    var Url = document.getElementById(felu);
    Url.select(); // 选择对象
    document.execCommand("Copy"); // 执行浏览器复制命令
    layer.msg('复制成功');
}

// 下载文件
function downloadVideo(url, desc) {
    if (isEmpty(url)) {
        layer.msg('暂无数据');
        return;
    }
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'blob';    // 返回类型blob
    xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
    xhr.setRequestHeader("Access-Control-Allow-Credentials", true);
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let blob = this.response;
            // 转换一个blob链接
            let u = window.URL.createObjectURL(new Blob([blob]))
            let a = document.createElement('a');
            a.download = desc + '.mp4';
            a.href = u;
            a.style.display = 'none'
            document.body.appendChild(a)
            a.click();
            a.remove();
        }
    };
    xhr.send()
}


$(document).ready(function () {

    //解析视频
    $('.qsy-submit').click(function () {

        $('.qsy-submit').attr('disabled', true);
        var link = rexUrl($('#qsy-url').val());
        if (isEmpty(link)) {
            layer.msg('请输入链接')
            $('.qsy-submit').attr('disabled', false);
            return false;
        }
        var index = layer.load(0);
        $.ajax({
            url: '/parseVideoUrl',
            type: 'POST',
            data: {"url": link},
            success: function (data) {
                $('.qsy-submit').attr('disabled', false);
                try {
                    var rows = JSON.parse(data);
                    layer.close(index);
                    layer.open({
                        type: 1,
                        title: false,
                        closeBtn: 1,
                        shadeClose: true,
                        skin: 'yourclass',
                        content: `<div style="overflow:hidden;height: 580px;width: 350px;"><div><div class="popButton"><a href="###" rel="noopener nofollow noreferrer" onclick="downloadVideo('${rows['videoUrl']}','${rows['desc']}')"><button class="layui-bg-red layui-btn-sm layui-btn">下载视频</button></a></div><div class="popButton"><textarea id="videourl" cols="1" rows="1" style="height:0;width:0;position: absolute;">${rows['videoUrl']}</textarea><button class="layui-btn-sm layui-bg-blue layui-btn" onclick="copy('videourl')">复制链接</button></div><div class="popButton"><a href="###" rel="noopener nofollow noreferrer" onclick="downloadVideo('${rows['musicUrl']}','${rows['desc']}')"><button class="layui-btn-sm layui-btn">下载音频</button></a></div><video id="video" width="360px" height="550px" src="${rows['videoUrl']}" controls = "true" poster="${rows['videoPic']}" preload="auto" webkit-playsinline="true" playsinline="true" x-webkit-airplay="allow" x5-video-player-type="h5" x5-video-player-fullscreen="true" x5-video-orientation="portraint" style="object-fit:fill"><source src="${rows['videoUrl']}" type="video/mp4"> </video></div></div>`
                    });
                } catch (error) {
                    layer.alert('错误信息:' + error, {
                        title: '异常',
                        skin: 'layui-layer-lan',
                        closeBtn: 0,
                        anim: 4 //动画类型
                    });
                    return false;
                }
            },
            error: function (err) {
                console.log(err);
                layer.close(index);
                $('.qsy-submit').attr('disabled', false);
            },
            done: function () {
                layer.close(index);
            }
        })
    })

    $('.reset_btn').click(function () {
        $('#qsy-url').val("");
    });
    $('.tool-vip-set').click(function () {
        $('.vip').fadeToggle();
    });
})