package com.snrtqi.buy.mapper;

import com.snrtqi.buy.pojo.OrdersCustom;

import java.util.List;

public interface OrdersMapperCustom {

    /**
     * 我的订单
     *
     * @param uid
     * @return
     */
    List<OrdersCustom> findOrdersById(String uid);

}