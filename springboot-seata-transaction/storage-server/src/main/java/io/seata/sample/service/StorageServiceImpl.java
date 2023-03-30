package io.seata.sample.service;

import io.seata.core.context.RootContext;
import io.seata.sample.dao.StorageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 小富 ，公众号：程序员内点事
 */
@Service("storageServiceImpl")
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageDao storageDao;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    @Override
    public void decrease(Long productId, Integer count) {
        String xid = RootContext.getXID();
        LOGGER.info("全局事务 xid： {}", xid);
        LOGGER.info("------->扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("------->扣减库存结束");
    }
}
