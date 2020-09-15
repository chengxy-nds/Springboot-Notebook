!function () {
    try {
        if (localStorage.getItem('ym_card') != null) {
            var c = document.getElementsByClassName('card-input')[0];
            c.value = localStorage.getItem('ym_card');
            var a = document.getElementsByClassName('card-submit')[0];
            var b = document.getElementsByClassName('card-quxiao')[0];
            a.style.display = 'none';
            b.style.display = 'block';
        }
    } catch (error) {
        console.log(error)
    }
}()

layui.use(['layer', 'element'], function () {
    var $ = layui.jquery;
})

function copy(felu) {
    var Url = document.getElementById(felu);
    Url.select(); // 选择对象
    document.execCommand("Copy"); // 执行浏览器复制命令
    layer.msg('复制成功');
}

$(document).ready(function () {

    //解析视频
    $('.qsy-submit').click(function () {



        $('.qsy-submit').attr('disabled', true);
        var link = rexUrl($('#qsy-url').val());
        if (isEmpty(link)) {
            layer.msg('没有检测到链接')
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
                        content: `<div class="layui-row layui-col-space10"style="background-image: url(${rows['videoPic']});background-size: cover;height: 500px;"><div class="layui-row layui-col-space10"><div class=" layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12"><a href="${rows['videoUrl']}"target="_blank"rel="noopener nofollow noreferrer"><button class="layui-btn">下载视频</button></a></div><div class="layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12"><a href="${rows['musicUrl']}" rel="noopener nofollow noreferrer"><button class="layui-btn">下载音乐</button></a></div><div class="layui-col-xs12 layui-col-sm12 layui-col-md12 layui-col-lg12"><textarea id="videourl"cols="30"rows="10" style="height:0;width:0;position: absolute;">${rows['videoUrl']}</textarea><button class="layui-btn"onclick="copy('videourl')">复制链接</button></div></div></div>`
                    });
                    layer.msg('解析成功');
                    return false;

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