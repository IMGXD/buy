package com.snrtqi.buy.service;

import com.snrtqi.buy.pojo.OrdersCustom;

import java.util.List;

/**
 * Created by Gumo on 2016/11/20.
 */
public interface OrdersService {

    /**
     * 添加订单
     *
     * @param ordersCustom
     * @throws Exception
     */
    void addOrders(OrdersCustom ordersCustom) throws Exception;

    /**
     * 我的订单
     *
     * @param uid
     * @return
     */
    List<OrdersCustom> myOrders(String uid);
}
