package com.xiaofu.sharding.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaofu.sharding.model.TConfig;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ConfigRepository extends BaseMapper<TConfig> {

}

