package io.seata.sample.service;

/**
 * @author 小富 ，公众号：程序员内点事
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    void decrease(Long productId, Integer count);
}
