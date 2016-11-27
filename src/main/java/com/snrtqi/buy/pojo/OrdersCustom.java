package com.snrtqi.buy.pojo;

import java.util.List;

/**
 * 订单的扩展类
 * Created by Gumo on 2016/11/12.
 */
public class OrdersCustom extends Orders {

    // 订单条目
    private List<OrderitemCustom> orderitemCustomList;

    public List<OrderitemCustom> getOrderitemCustomList() {
        return orderitemCustomList;
    }

    public void setOrderitemCustomList(List<OrderitemCustom> orderitemCustomList) {
        this.orderitemCustomList = orderitemCustomList;
    }
}
