package com.springboot101.params;

import javax.validation.GroupSequence;

/**
 * 分组校验 - 定义分组
 */

/**
 * 分组校验 - 定义分组
 * @author 公众号：程序员小富
 * @date 2023/10/24 11:02
 */
public class ValidGroup {

    // 新增使用
    public interface Insert {
    }

    // 更新使用
    public interface Update {
    }

    // 删除使用
    public interface Delete {
    }

    // 属性必须有这两个分组的才验证(配合spring的@Validated功能分组使用)
    @GroupSequence({Insert.class, Update.class, Delete.class})
    public interface All {
    }
}