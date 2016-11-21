package com.snrtqi.buy.pojo;

import java.util.List;

/**
 * 订单的扩展类
 * Created by Gumo on 2016/11/12.
 */
public class OrdersCustom extends Orders {

    // 订单条目
    private List<Orderitem> orderitemList;

    public List<Orderitem> getOrderitemList() {
        return orderitemList;
    }

    public void setOrderitemList(List<Orderitem> orderitemList) {
        this.orderitemList = orderitemList;
    }
}
