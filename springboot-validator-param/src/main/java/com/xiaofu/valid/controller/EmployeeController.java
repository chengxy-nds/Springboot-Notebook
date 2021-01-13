package com.xiaofu.valid.controller;

import com.sun.xml.internal.bind.v2.TODO;
import com.xiaofu.valid.vo.Employee;
import com.xiaofu.valid.vo.Resp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:
 * @Description:
 */
@Controller
@RequestMapping
public class EmployeeController {

    @PostMapping(value = "/addEmployee")
    @ResponseBody
    public Resp addEmployee(Employee employee) {

        if (employee.getEmployeeName() == null) {
            return Resp.error(601, "员工姓名不能为空");
        }

        if (employee.getMobile() == null) {
            return Resp.error(602, "手机号不能为空");
        }

        if (employee.getAddress() == null) {
            return Resp.error(603, "员工地址不能为空");
        }
        //TODO 插入员工逻辑
        return Resp.ok(null);
    }

    @PostMapping(value = "/deleteEmployee")
    @ResponseBody
    public Resp deleteEmployee(Employee employee) {

        if (employee.getEmployeeId() == null) {
            return Resp.error(604, "员工Id不能为空");
        }
        return Resp.ok(null);
    }
}
