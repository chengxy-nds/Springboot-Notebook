package com.shardingsphere_101.controller;

import com.shardingsphere_101.entity.Order;
import com.shardingsphere_101.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单 API
 *
 * @author Jiahai
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 新增
     *
     * @return Order
     */
    @PostMapping
    public Order save() {
        return orderService.save();
    }

    /**
     * 删除
     *
     * @param orderId 订单ID
     */
    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable Long orderId) {
        orderService.delete(orderId);
    }

    /**
     * 修改
     *
     * @param orderId 订单ID
     */
    @PutMapping
    public void update(Long orderId) {
        orderService.update(orderId);
    }

    /**
     * 根据主键ID查询
     *
     * @param orderId 订单ID
     * @return Order
     */
    @GetMapping("/{orderId}")
    public Order findById(@PathVariable Long orderId) {
        return orderService.findById(orderId);
    }

    /**
     * 列表查询（根据主键ID顺序）
     *
     * @return List<Order>
     */
    @GetMapping("/list")
    public List<Order> list() {
        return orderService.list();
    }

    /**
     * 分页查询（根据主键ID逆序）
     *
     * @param page 当前页
     * @param size 每页条数
     * @return Page<Order>
     */
    @GetMapping("/page/{page}/{size}")
    public Page<Order> page(@PathVariable int page, @PathVariable int size) {
        return orderService.page(page, size);
    }
}