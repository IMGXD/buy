package com.snrtqi.buy.pojo;

/**
 * 订单的包装类型
 * Created by Gumo on 2016/11/19.
 */
public class OrdersQueryVo {

    // 订单的扩展类
    private OrdersCustom ordersCustom;

    public OrdersCustom getOrdersCustom() {
        return ordersCustom;
    }

    public void setOrdersCustom(OrdersCustom ordersCustom) {
        this.ordersCustom = ordersCustom;
    }
}
