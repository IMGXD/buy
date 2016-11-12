package com.snrtqi.buy.pojo;

/**
 * 订单的包装对象
 * Created by Gumo on 2016/11/12.
 */
public class OrdersQueryVo {

    // 订单类
    private Orders orders;

    // 订单的扩展类
    private OrdersCustom ordersCustom;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public OrdersCustom getOrdersCustom() {
        return ordersCustom;
    }

    public void setOrdersCustom(OrdersCustom ordersCustom) {
        this.ordersCustom = ordersCustom;
    }
}
