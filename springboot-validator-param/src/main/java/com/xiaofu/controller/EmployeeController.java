package com.xiaofu.controller;

import com.xiaofu.vo.DeleteEmployeeVo;
import com.xiaofu.vo.Employee;
import com.xiaofu.vo.EmployeeVo;
import com.xiaofu.vo.Resp;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Author:
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping
public class EmployeeController {

    @PostMapping(value = "/addEmployee")
    @ResponseBody
    public Resp addEmployee(@Valid EmployeeVo employeeVo, BindingResult result) {

        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                log.info("校验结果：" + error.getDefaultMessage());
            }
        }

        if (employeeVo.getEmployeeName() == null) {
            return Resp.error(601, "员工姓名不能为空");
        }

        if (employeeVo.getMobile() == null) {
            return Resp.error(602, "手机号不能为空");
        }

        if (employeeVo.getAddress() == null) {
            return Resp.error(603, "员工地址不能为空");
        }
        //TODO 插入员工逻辑
        return Resp.ok(null);
    }

    @PostMapping(value = "/deleteEmployee")
    @ResponseBody
    public Resp deleteEmployee(@Valid DeleteEmployeeVo deleteEmployeeVo) {

        if (deleteEmployeeVo.getEmployeeId() == null) {
            return Resp.error(604, "员工Id不能为空");
        }
        return Resp.ok(null);
    }
}
