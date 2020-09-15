/*
 * @Date: 2020-07-19 19:17:11
 * @LastEditors: YouMi.ee
 * @LastEditTime: 2020-07-28 09:20:25
 * @FilePath: \removelogo\static\js\ymtool.js
 */
//判空
function isEmpty(obj) {
    if (typeof obj == "undefined" || obj == null || obj == "") {
        return true;
    } else {
        return false;
    }
}
//吧php返回的json字符串转换成json对象
function json_p(responseText) {
    var rows = responseText.toString().replace(/Array/, '');
    eval('var rowss=' + rows);
    return rowss;
}

//取出链接
function rexUrl(str) {
    try {
        var s = /(http|https)[:\/\w\d\.\s&-_]+/.exec(str);
        var ss = s[0].replace('/\s/g', "").trim();
        return ss;
    } catch (error) {
        return null;
    }
}

//时间戳转格式
function formatDate(date) {
    var date = new Date(date);
    var YY = date.getFullYear() + '-';
    var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
    var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
    var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
    return YY + MM + DD + " " + hh + mm + ss;
}



var minute = 1000 * 60;
var hour = minute * 60;
var day = hour * 24;
var halfamonth = day * 15;
var month = day * 30;
//时间差
function getDateDiff(setdateTimeStamp) {
    var dateTimeStamp = new Date(setdateTimeStamp);
    var now = new Date().getTime();
    var diffValue = now - dateTimeStamp;
    if (diffValue < 0) {
        //若日期不符则弹出窗口告之
        return "结束日期不能小于开始日期！";
    }
    var monthC = diffValue / month;
    var weekC = diffValue / (7 * day);
    var dayC = diffValue / day;
    var hourC = diffValue / hour;
    var minC = diffValue / minute;
    if (monthC >= 1) {
        result = parseInt(monthC) + "月前";
    } else if (weekC >= 1) {
        result = parseInt(weekC) + "周前";
    } else if (dayC >= 1) {
        result = parseInt(dayC) + "天前";
    } else if (hourC >= 1) {
        result = parseInt(hourC) + "小时前";
    } else if (minC >= 1) {
        result = parseInt(minC) + "分钟前";
    } else {
        result = "刚刚";
    }
    return result;
}