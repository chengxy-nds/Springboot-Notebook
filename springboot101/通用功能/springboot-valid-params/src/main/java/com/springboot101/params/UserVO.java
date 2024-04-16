package com.springboot101.params;


import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * gon
 */
@Data
public class UserVO {

    @NotBlank(message = "姓名不为空", groups = ValidGroup.Insert.class)
    private String username;

    @NotBlank(message = "密码不为空", groups = ValidGroup.Update.class)
    private String password;

    @Min(value = 18, message = "年龄不小于18", groups = {ValidGroup.Update.class, ValidGroup.Insert.class})
    @Max(value = 100, message = "年龄不大于100", groups = {ValidGroup.Update.class, ValidGroup.Insert.class})
    @NotNull(message = "age不为空", groups = {ValidGroup.Update.class, ValidGroup.Insert.class})
    private int age;

    @Email(message = "邮件格式不对")
    @NotBlank(message = "邮件不为空", groups = ValidGroup.Insert.class)
    private String email;

    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Future(message = "必须是将来时间")
    @NotNull(message = "createTime不为空", groups = {ValidGroup.Update.class, ValidGroup.Insert.class})
    private Date createTime;

    @GetMapping("/hello")
    public String getStr() {
        return "hello,javadaily";
    }

}