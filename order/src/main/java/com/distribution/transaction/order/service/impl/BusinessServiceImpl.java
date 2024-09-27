package com.distribution.transaction.order.service.impl;

import com.distribution.transaction.order.service.BusinessService;
import com.distribution.transaction.order.service.OrderService;
import com.distribution.transaction.storage.service.StorageService;

public class BusinessServiceImpl implements BusinessService {

    private StorageService storageService;

    private OrderService orderService;

    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageService.deduct(commodityCode, orderCount);
        orderService.create(userId, commodityCode, orderCount);
    }
}
