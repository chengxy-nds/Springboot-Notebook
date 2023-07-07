package com.springboot101.handler;

import com.springboot101.domain.OrderContext;

/**
 * 订单责任链处理器
 *
 * @author 公众号：程序员小富
 * @date 2023/07/03 11:02
 */
public abstract class AbstractOrderHandler {

    /**
     * 责任链，下一个链接节点
     */
    private AbstractOrderHandler next;

    /**
     * 执行入口
     *
     * @param context
     */
    public boolean execute(OrderContext context) {
        boolean flag = handle(context);
        // 判断是否还有下个责任链节点，没有的话，说明已经是最后一个节点
        if (getNext() != null) {
            getNext().execute(context);
        }
        return flag;
    }

    /**
     * 对参数进行处理
     *
     * @param context
     * @return
     */
    public abstract boolean handle(OrderContext context);


    public AbstractOrderHandler getNext() {
        return next;
    }

    public void setNext(AbstractOrderHandler next) {
        this.next = next;
    }
}