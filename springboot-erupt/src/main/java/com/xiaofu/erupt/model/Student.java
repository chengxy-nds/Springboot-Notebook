package com.xiaofu.erupt.model;

import org.hibernate.annotations.GenericGenerator;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.HtmlEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.*;
import java.util.Date;

/*
 *  @Erupt注解修饰在类上，@EruptField注解修饰在字段上
 *  其他注解均为Jpa注解
 */
@Erupt(name = "学生表",
        power = @Power(importable = true, export = true)
)
@Entity
//@Table(name = "t_student")
public class Student extends BaseModel {

    @EruptField(
            views = @View(title = "学生姓名"),
            edit = @Edit(title = "学生姓名", notNull = true, search = @Search(vague = true))
    )
    private String studentName;

    @EruptField(
            views = @View(title = "所属班级"),
            edit = @Edit(title = "所属班级", notNull = true)
    )
    private String studentClass;

    @EruptField(
            views = @View(title = "学生年龄"),
            edit = @Edit(title = "学生年龄", notNull = true)
    )
    private String studentAge;

    @Lob
    @EruptField(
            views = @View(title = "学生性别"),
            edit = @Edit(title = "学生性别", notNull = true)
    )
    private String studentSex;

    @EruptField(
            views = @View(title = "考核状态"),
            edit = @Edit(title = "考核状态", notNull = true, boolType = @BoolType(trueText = "通过", falseText = "挂科"), search = @Search)
    )
    private Boolean status;


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}