package com.shardingsphere_101.keyGenerator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shardingsphere_101.keyGenerator.entity.OrderPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<OrderPo> {

}