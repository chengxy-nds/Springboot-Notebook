package com.xiaofu.sharding.utils;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @Author: xinzhifu
 * @Description:
 */
@Slf4j
public class JasyptUtil {

    /**
     * 加密方法
     *
     * @param salt         盐值
     * @param targetString 待加密字符串
     * @return 密文
     */
    public static String encrypt(String salt, String targetString) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(salt);
        return encryptor.encrypt(targetString);
    }

    /**
     * 解密方法
     *
     * @param salt         盐值
     * @param targetString 待解密字符串
     * @return 明文
     */
    public static String decrypt(String salt, String targetString) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(salt);
        return encryptor.decrypt(targetString);
    }

    public static void main(String[] args) {

        String salt = "order_database";
        String username = "root";
        String password = "xinzhifu521";
        // 进行加密操作
        String usernameEncryptStr = encrypt(salt, username);
        String passwordEncryptStr = encrypt(salt, password);
        // 进行解密操作
        String usernameDecryptStr = decrypt(salt, usernameEncryptStr);
        String passwordDecryptStr = decrypt(salt, passwordEncryptStr);
        // 输出明文和密文
        log.info("usernameEncrypt :{}", usernameEncryptStr);
        log.info("passwordEncryptStr :{}", passwordEncryptStr);
    }
}
