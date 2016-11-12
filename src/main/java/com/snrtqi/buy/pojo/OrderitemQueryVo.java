package com.snrtqi.buy.pojo;

/**
 * 订单条目的包装对象
 * Created by Gumo on 2016/11/12.
 */
public class OrderitemQueryVo {

    // 订单条目类
    private Orderitem orderitem;

    // 订单条目的扩展类
    private OrderitemCustom orderitemCustom;

    public Orderitem getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(Orderitem orderitem) {
        this.orderitem = orderitem;
    }

    public OrderitemCustom getOrderitemCustom() {
        return orderitemCustom;
    }

    public void setOrderitemCustom(OrderitemCustom orderitemCustom) {
        this.orderitemCustom = orderitemCustom;
    }
}
