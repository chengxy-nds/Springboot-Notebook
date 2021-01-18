package com.xiaofu.vo;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeVo {

    @NotNull(message = "员工ID不能为空")
    private Integer employeeId;

    @NotNull(message = "员工姓名不能为空")
    private String employeeName;

    @NotNull(message = "员工地址不能为空")
    private String address;

    @NotNull(message = "手机号不能为空")
    private String mobile;
}
