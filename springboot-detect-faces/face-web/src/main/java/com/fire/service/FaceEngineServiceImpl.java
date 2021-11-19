package com.fire.service;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.toolkit.ImageInfo;
import com.fire.entity.User;
import com.fire.repository.UserDao;
import com.fire.util.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;

@Slf4j
@Component
public class FaceEngineServiceImpl implements FaceEngineService {

    @Resource
    private UserDao userDao;

    @Value("${face.appId}")
    private String appId;

    @Value("${face.sdkKey}")
    private String sdkKey;

    @Value("${face.path}")
    private String path;

    public Integer errorCode;

    public FaceEngine faceEngine;

    @PostConstruct
    public void init() {

        faceEngine = new FaceEngine(path);
        /**
         * 激活引擎
         */
        int errorCode = faceEngine.activeOnline(appId, sdkKey);
        log.info("激活引擎 ,errorCode: {}", errorCode);
        if (errorCode != ErrorInfo.MOK.getValue() && errorCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            log.error("引擎激活失败,errorCode: {}", errorCode);
        }
        ActiveFileInfo activeFileInfo = new ActiveFileInfo();
        errorCode = faceEngine.getActiveFileInfo(activeFileInfo);
        if (errorCode != ErrorInfo.MOK.getValue() && errorCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            log.error("获取激活文件信息失败 ,errorCode: {}", errorCode);
        }
        /**
         * 引擎配置
         */
        com.arcsoft.face.EngineConfiguration engineConfiguration = new com.arcsoft.face.EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_ALL_OUT);
        engineConfiguration.setDetectFaceMaxNum(10);
        engineConfiguration.setDetectFaceScaleVal(16);
        /**
         * 功能配置
         */
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);
        /**
         * 初始化引擎
         */
        errorCode = faceEngine.init(engineConfiguration);
        if (errorCode != ErrorInfo.MOK.getValue()) {
            log.error("初始化引擎失败 ,errorCode: {}", errorCode);
        }
    }

    @Override
    public User detectFaces(String file) {

        try {
            // file 字符串转 file 流
            byte[] decode = Base64.decode(Base64Util.base64Process(file));

            // 人脸图像检测
            ImageInfo imageInfo = getRGBData(decode);
            List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
            errorCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);
            log.info("人脸图像检测 ,faceInfoList: {} ,errorCode: {}", JSON.toJSONString(faceInfoList), errorCode);

            // 提取人脸特征
            FaceFeature faceFeature = new FaceFeature();
            errorCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList.get(0), faceFeature);
            log.info("提取人脸特征大小，getFeatureData: {} ,errorCode：{}", faceFeature.getFeatureData().length, errorCode);

            List<User> allUser = userDao.findAll();
            if (!CollectionUtils.isEmpty(allUser)) {
                for (User user : allUser) {
                    if (Objects.isNull(user.getDetectFaces())) {
                        continue;
                    }
                    FaceSimilar faceSimilar = new FaceSimilar();
                    errorCode = faceEngine.compareFaceFeature(
                            getFaceFeatureInstance(faceFeature.getFeatureData()),
                            getFaceFeatureInstance(user.getDetectFaces()), faceSimilar);
                    log.info("相似度：{}", faceSimilar.getScore());
                    if (faceSimilar.getScore() >= 0.8) {
                        user.setFirstLogin(false);
                        log.info("老用户");
                        return user;
                    }
                }
            }
            User newUser = createNewUser(faceFeature.getFeatureData());
            newUser.setFirstLogin(true);
            log.info("新用户");
            return newUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 人脸识别后-创建新用户
     *
     * @param detectFaces
     * @return
     */
    public User createNewUser(byte[] detectFaces) {
        User currentUser = new User();
        currentUser.setGender(getGender());
        currentUser.setUserName("火书网友");
        currentUser.setAvatarPath("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201612%2F02%2F20161202182753_ViyLX.thumb.700_0.png&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1638539316&t=3725638b9");
        currentUser.setDetectFaces(detectFaces);
        currentUser.setFirstLogin(true);
        currentUser = userDao.save(currentUser);
        return currentUser;
    }

    /**
     * 检测性别
     *
     * @return
     */
    public Integer getGender() {
        List<GenderInfo> genderInfoList = new ArrayList<>();
        errorCode = faceEngine.getGender(genderInfoList);
        if (!CollectionUtils.isEmpty(genderInfoList)) {
            log.info("性别：{} ,errorCode: {}", genderInfoList.get(0).getGender(), errorCode);
            return genderInfoList.get(0).getGender();
        }
        return -1;
    }

    public FaceFeature getFaceFeatureInstance(byte[] detectFaces) {
        FaceFeature faceFeature = new FaceFeature();
        faceFeature.setFeatureData(detectFaces);
        return faceFeature;
    }
}
