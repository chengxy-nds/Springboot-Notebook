package com.fire.storage.da;

import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.UploadPretreatment;
import cn.xuyanwu.spring.file.storage.aspect.*;
import cn.xuyanwu.spring.file.storage.platform.FileStorage;
import cn.xuyanwu.spring.file.storage.recorder.FileRecorder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.function.Consumer;

/**
 * 使用切面打印文件上传和删除的日志
 */
@Slf4j
@Component
public class LogFileStorageAspect implements FileStorageAspect {

    /**
     * 上传，成功返回文件信息，失败返回 null
     */
    @Override
    public FileInfo uploadAround(UploadAspectChain chain, FileInfo fileInfo, UploadPretreatment pre, FileStorage fileStorage, FileRecorder fileRecorder) {
        log.info("上传文件 before -> {}",fileInfo);
        fileInfo = chain.next(fileInfo,pre,fileStorage,fileRecorder);
        log.info("上传文件 after -> {}",fileInfo);
        return fileInfo;
    }

    /**
     * 删除文件，成功返回 true
     */
    @Override
    public boolean deleteAround(DeleteAspectChain chain, FileInfo fileInfo, FileStorage fileStorage, FileRecorder fileRecorder) {
        log.info("删除文件 before -> {}",fileInfo);
        boolean res = chain.next(fileInfo,fileStorage,fileRecorder);
        log.info("删除文件 after -> {}",res);
        return res;
    }

    /**
     * 文件是否存在
     */
    @Override
    public boolean existsAround(ExistsAspectChain chain, FileInfo fileInfo, FileStorage fileStorage) {
        log.info("文件是否存在 before -> {}",fileInfo);
        boolean res = chain.next(fileInfo,fileStorage);
        log.info("文件是否存在 after -> {}",res);
        return res;
    }

    /**
     * 下载文件
     */
    @Override
    public void downloadAround(DownloadAspectChain chain, FileInfo fileInfo, FileStorage fileStorage, Consumer<InputStream> consumer) {
        log.info("下载文件 before -> {}",fileInfo);
        chain.next(fileInfo,fileStorage,consumer);
        log.info("下载文件 after -> {}",fileInfo);
    }

    /**
     * 下载缩略图文件
     */
    @Override
    public void downloadThAround(DownloadThAspectChain chain,FileInfo fileInfo,FileStorage fileStorage,Consumer<InputStream> consumer) {
        log.info("下载缩略图文件 before -> {}",fileInfo);
        chain.next(fileInfo,fileStorage,consumer);
        log.info("下载缩略图文件 after -> {}",fileInfo);
    }
}

