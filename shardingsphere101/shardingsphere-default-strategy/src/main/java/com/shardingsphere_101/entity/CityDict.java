package com.shardingsphere_101.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_city_dict")
@Data
public class CityDict {

    private Long id;
    private String cityName;
    private String provinceName;
    private String countryName;
    private Integer population;
    private Integer area;
}
