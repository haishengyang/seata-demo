package com.distribution.transaction.order.service;

import com.distribution.transaction.account.service.AccountService;
import com.distribution.transaction.order.mapper.OrderMapper;
import com.distribution.transaction.order.po.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final AccountService accountService;

    private final OrderMapper orderMapper;

    public OrderServiceImpl(AccountService accountService, OrderMapper orderMapper) {
        this.accountService = accountService;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order create(String userId, String commodityCode, int orderCount) {
        int orderMoney = calculate(commodityCode, orderCount);

        accountService.debit(userId, orderMoney);
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);
        orderMapper.insert(order);
        return order;
    }

    private int calculate(String commodityCode, int count) {
        return 200 * count;
    }
}
