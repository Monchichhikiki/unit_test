package com.mx.unit.test.adapter;

import com.mx.unit.test.vo.Order;

/**
 * @author qiqi
 * @date 2020-05-31 15:27
 */

public interface OrderAdapter {

    /**
     * 获取订单详情
     *
     * @param orderNo
     * @return
     */
    Order getOrderDetail(long orderNo);

    /**
     * 是否是当前用户
     *
     * @param userId
     * @return
     */
    boolean isUser(long userId);

}
