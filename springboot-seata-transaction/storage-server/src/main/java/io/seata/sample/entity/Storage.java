package io.seata.sample.entity;

import lombok.Data;

/**
 * @author 小富 ，公众号：程序员内点事
 */
@Data
public class Storage {

    private Long id;

    /**产品id*/
    private Long productId;

    /**总库存*/
    private Integer total;

    /**已用库存*/
    private Integer used;

    /**剩余库存*/
    private Integer residue;
}
