package com.xiaofu.erupt.proxy;

import com.xiaofu.erupt.model.Student;
import org.apache.poi.ss.usermodel.Workbook;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.core.exception.EruptApiErrorTip;
import xyz.erupt.jpa.dao.EruptDao;
import xyz.erupt.jpa.dao.EruptJpaDao;

import java.util.Collection;
import java.util.Map;

public class StudentDataProxy implements DataProxy<Student> {

    private EruptDao eruptDao;

    private EruptJpaDao eruptJpaDao;

    @Override
    public void beforeAdd(Student student) {

        //后台字段校验
        if ("张三".equals(student.getStudentName())) {
            throw new EruptApiErrorTip("名称禁止为张三！");
        }
    }

    @Override
    public void afterAdd(Student student) {

    }

    @Override
    public void afterUpdate(Student student) {

    }

    @Override
    public void afterDelete(Student student) {
    }


    @Override
    public void beforeUpdate(Student student) {

    }

    @Override
    public void beforeDelete(Student student) {

    }

    @Override
    public String beforeFetch() {
        return null;
    }

    @Override
    public void afterFetch(Collection<Map<String, Object>> list) {

    }

    @Override
    public void addBehavior(Student student) {

    }

    @Override
    public void editBehavior(Student student) {

    }

    @Override
    public void excelExport(Workbook wb) {

    }

    @Override
    public void excelImport(Student student) {

    }
}