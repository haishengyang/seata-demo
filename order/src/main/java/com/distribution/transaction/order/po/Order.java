package com.distribution.transaction.order.po;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String userId;
    private String commodityCode;
    private int count;
    private int money;
}
