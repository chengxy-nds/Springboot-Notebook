package com.springboot101.domain;

import lombok.Data;

/**
 * 订单责任链处理器
 *
 * @author 公众号：程序员小富
 * @date 2023/07/03 11:02
 */
@Data
public class OrderContext {

    /**
     * 请求唯一序列ID
     */
    private String seqId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 产品skuId
     */
    private Long skuId;

    /**
     * 下单数量
     */
    private Integer amount;
}