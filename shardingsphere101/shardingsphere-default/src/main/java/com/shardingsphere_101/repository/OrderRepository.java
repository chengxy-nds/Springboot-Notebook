package com.shardingsphere_101.repository;

import com.shardingsphere_101.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
