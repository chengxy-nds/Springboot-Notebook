package com.fire.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户
 *
 * @author xiaofu
 * @Description: 用户
 * @date 2021/09/15
 */
@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
@Table(name = "fire_user")
public class User extends BaseEntity {

    /**
     * 账号
     */
    private String accountId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 头像
     */
    private String avatarPath;

    /**
     * 是否为管理员
     */
    private boolean isAdmin;

    /**
     * 启用状态
     */
    private boolean enabled;

    /**
     * 密码重置时间
     */
    private Date pwdResetRime;

    /**
     * 个人简介
     */
    private String personalDesc;

    /**
     * 人脸识别信息
     */
    private byte[] detectFaces;

    /**
     * 未知性别=-1 、男性=0 、女性=1
     */
    private Integer gender = -1;

    /**
     * 是否为第一次登录的新用户
     */
    private boolean firstLogin;
}
