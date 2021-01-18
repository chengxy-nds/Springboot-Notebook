package com.xiaofu.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddEmployeeVo {

    @NotNull
    private Integer employeeId;

    private String employeeName;

    private String address;

    private String mobile;
}
