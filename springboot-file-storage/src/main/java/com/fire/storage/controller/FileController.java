

package com.fire.storage.controller;

import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.FileStorageService;
import cn.xuyanwu.spring.file.storage.ProgressListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;

/**
 * 公众号：程序员小富
 * 上传文件Controller
 */
@RestController
public class FileController {
    @Autowired
    private FileStorageService fileStorageService;

    /**
     * 公众号：程序员小富
     * 上传文件
     */
    @PostMapping(value = {"/upload"})
    public Object upload(MultipartFile file) {
        FileInfo upload = fileStorageService.of(file).upload();
        return upload;
    }

    /**
     * 公众号：程序员小富
     * 上传图片裁剪大小并生成一张缩略图
     */
    @PostMapping("/uploadThumbnail")
    public FileInfo uploadThumbnail(MultipartFile file) {
        return fileStorageService.of(file)
                .image(img -> img.size(1000, 1000))  //将图片大小调整到 1000*1000
                .thumbnail(th -> th.size(200, 200))  //再生成一张 200*200 的缩略图
                .upload();
    }

    /**
     * 公众号：程序员小富
     * 上传文件到指定存储平台，成功返回文件信息
     */
    @PostMapping("/upload-platform")
    public FileInfo uploadPlatform(MultipartFile file) {
        return fileStorageService.of(file)
                .setPlatform("aliyun-oss")    //使用指定的存储平台
                .upload();
    }

    /**
     * 公众号：程序员小富
     * 下载文件
     */
    @PostMapping("/download")
    public void download(MultipartFile file) {
        // 获取文件信息
        FileInfo fileInfo = fileStorageService.getFileInfoByUrl("http://file.abc.com/test/a.jpg");

        // 下载为字节数组
        byte[] bytes = fileStorageService.download(fileInfo).bytes();

        // 下载到文件
        fileStorageService.download(fileInfo).file("C:\\a.jpg");

        // 下载到 OutputStream 中
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        fileStorageService.download(fileInfo).outputStream(out);

        // 获取 InputStream 手动处理
        fileStorageService.download(fileInfo).inputStream(in -> {
            //TODO 读取 InputStream
        });

        // 直接通过文件信息中的 url 下载，省去手动查询文件信息记录的过程
        fileStorageService.download("http://file.abc.com/test/a.jpg").file("C:\\a.jpg");

        // 下载缩略图
        fileStorageService.downloadTh(fileInfo).file("C:\\th.jpg");

        // 下载文件 显示进度
        fileStorageService.download(fileInfo).setProgressMonitor(new ProgressListener() {
            @Override
            public void start() {
                System.out.println("下载开始");
            }

            @Override
            public void progress(long progressSize,long allSize) {
                System.out.println("已下载 " + progressSize + " 总大小" + allSize);
            }

            @Override
            public void finish() {
                System.out.println("下载结束");
            }
        }).file("C:\\a.jpg");
    }
}
