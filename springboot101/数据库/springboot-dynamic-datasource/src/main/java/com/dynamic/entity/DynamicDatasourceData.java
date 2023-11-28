package com.dynamic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_dynamic_datasource_data")
@Data
public class DynamicDatasourceData {

    private Long id;
    private String sourceName;
}
