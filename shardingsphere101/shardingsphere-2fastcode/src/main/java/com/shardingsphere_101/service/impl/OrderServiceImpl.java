package com.shardingsphere_101.service.impl;

import com.shardingsphere_101.entity.Order;
import com.shardingsphere_101.repository.OrderRepository;
import com.shardingsphere_101.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.LongStream;

/**
 * 订单业务层接口实现类
 *
 * @author Jiahai
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order save() {
        // 新增订单ID从1~10的测试数据
        LongStream.range(1, 11).forEach(value -> orderRepository.save(new Order(value, new Date())));
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Long orderId) {
        orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("ID不存在")).setCreateTime(new Date());
    }

    @Override
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("ID不存在"));
    }

    @Override
    public List<Order> list() {
        return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "orderId"));
    }

    @Override
    public Page<Order> page(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "orderId"));
        return this.orderRepository.findAll(pageRequest);
    }
}