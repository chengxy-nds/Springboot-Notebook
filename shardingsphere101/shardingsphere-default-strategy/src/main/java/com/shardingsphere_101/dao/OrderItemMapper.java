package com.shardingsphere_101.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shardingsphere_101.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}