package com.shardingsphere_101.keyGenerator.entity;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.shardingsphere.sharding.cosid.algorithm.keygen.CosIdSnowflakeKeyGenerateAlgorithm;
import org.apache.shardingsphere.sharding.nanoid.algorithm.keygen.NanoIdKeyGenerateAlgorithm;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 订单实体类
 */
@Data
@TableName("t_order")
public class OrderPo {
    private transient Long Id;
    private Long orderId;
    private Long userId;
    private String orderNumber;
    private Long customerId;
    private Date orderDate;
    private BigDecimal totalAmount;
    private String intervalValue;
}