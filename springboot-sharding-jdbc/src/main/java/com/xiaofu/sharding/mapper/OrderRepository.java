package com.xiaofu.sharding.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofu.sharding.model.TOrder;
import com.xiaofu.sharding.model.TOrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface OrderRepository extends BaseMapper<TOrder> {


    List<TOrderDto> selectOrderAndItemByOrderId(TOrderDto tOrder);

    IPage<TOrderDto> selectOrderAndItemByOrderIdPage(Page<TOrderDto> page, @Param("pageNo") Integer pageNo,
                                                     @Param("pageSize") Integer pageSize, @Param("orderId") Long orderId);

    List<TOrderDto> selectOrderListPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize, @Param("orderId") Long orderId);
}

