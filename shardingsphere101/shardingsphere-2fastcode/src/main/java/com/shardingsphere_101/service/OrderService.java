package com.shardingsphere_101.service;

import com.shardingsphere_101.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 订单业务层接口
 *
 * @author Jiahai
 */
public interface OrderService {
    /**
     * 新增（测试数据）
     *
     * @return
     */
    Order save();

    /**
     * 根据ID删除
     *
     * @param orderId
     */
    void delete(Long orderId);

    /**
     * 更新（创建时间）
     *
     * @param orderId
     */
    void update(Long orderId);

    /**
     * 根据主键查询
     *
     * @param orderId 订单ID
     * @return
     */
    Order findById(Long orderId);

    /**
     * 列表查询（根据主键ID顺序）
     *
     * @return
     */
    List<Order> list();

    /**
     * 分页查询（根据主键ID逆序）
     *
     * @param page 当前页
     * @param size 每页条数
     * @return
     */
    Page<Order> page(int page, int size);
}