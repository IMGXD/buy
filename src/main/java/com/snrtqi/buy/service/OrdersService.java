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
    List<OrdersCustom> myOrders(String uid) throws Exception;

    /**
     * 加载单个订单
     *
     * @param oid
     * @return
     * @throws Exception
     */
    OrdersCustom loadOrder(String oid) throws Exception;

    /**
     * 确认收货
     *
     * @param oid
     * @throws Exception
     */
    void confirm(String oid) throws Exception;

    /**
     * 支付
     *
     * @param oid
     * @throws Exception
     */
    void pay(String oid) throws Exception;

    /**
     * 所有订单
     *
     * @return
     * @throws Exception
     */
    List<OrdersCustom> findOrderList() throws Exception;

    /**
     * 通过订单状态查询订单列表
     *
     * @param state
     * @return
     * @throws Exception
     */
    List<OrdersCustom> findOrderListByState(String state) throws Exception;

    /**
     * 发货
     *
     * @param oid
     * @throws Exception
     */
    void send(String oid) throws Exception;
}
