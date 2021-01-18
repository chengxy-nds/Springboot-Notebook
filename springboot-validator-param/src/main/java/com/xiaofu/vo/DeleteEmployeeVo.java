package com.xiaofu.vo;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

@Data
public class DeleteEmployeeVo {

    @NotNull(message = "员工ID不能为空")
    private Integer employeeId;

    @NotNull(message = "员工姓名不能为空")
    private String employeeName;

    @NotNull(message = "员工地址不能为空")
    private String address;

    @NotNull(message = "手机号不能为空")
    private String mobile;

    @DecimalMax(
            value = "350",
            message = "The top speed ${formatter.format('%1$.2f', validatedValue)} is higher " +
                    "than {value}"
    )
    private double topSpeed;
}
