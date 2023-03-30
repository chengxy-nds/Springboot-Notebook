package io.seata.sample.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 小富 ，公众号：程序员内点事
 */
@Data
public class Account {

    private Long id;

    /**用户id*/
    private Long userId;

    /**总额度*/
    private BigDecimal total;

    /**已用额度*/
    private BigDecimal used;

    /**剩余额度*/
    private BigDecimal residue;
}
