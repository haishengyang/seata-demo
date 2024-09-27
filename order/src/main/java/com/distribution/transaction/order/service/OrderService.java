package com.distribution.transaction.order.service;

import com.distribution.transaction.order.po.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    Order create(String userId, String commodityCode, int orderCount);
}
