package com.xiaofu.erupt.model;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.SliderType;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: zhifu.xin@ipinyou.com
 * @Date: 2021/3/24 20:36
 * @Description:
 */
@Table(name = "demo_simple")
@Entity
@Erupt(name = "简单示例")
public class Simple extends BaseModel {

    @EruptField(
            views = @View(title = "文本"),
            edit = @Edit(title = "文本", notNull = true, search = @Search)
    )
    private String input;

    @EruptField(
            views = @View(title = "数值", sortable = true),
            edit = @Edit(title = "数值", search = @Search)
    )
    private Float number;

    @EruptField(
            views = @View(title = "布尔"),
            edit = @Edit(title = "布尔")
    )
    private Boolean bool;

    @EruptField(
            views = @View(title = "时间"),
            edit = @Edit(title = "时间", search = @Search(vague = true))
    )
    private Date date;

    @EruptField(
            views = @View(title = "滑动条"),
            edit = @Edit(title = "滑动条", type = EditType.SLIDER, search = @Search,
                    sliderType = @SliderType(max = 100, markPoints = {30, 60}))
    )
    private Integer slide;

}