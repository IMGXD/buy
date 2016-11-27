package com.snrtqi.buy.service.impl;

import com.snrtqi.buy.exception.OrdersException;
import com.snrtqi.buy.mapper.OrderitemMapperCustom;
import com.snrtqi.buy.mapper.OrdersMapper;
import com.snrtqi.buy.mapper.OrdersMapperCustom;
import com.snrtqi.buy.pojo.Orders;
import com.snrtqi.buy.pojo.OrdersCustom;
import com.snrtqi.buy.service.OrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Gumo on 2016/11/20.
 */
public class OrdersServiceImpl implements OrdersService {

    //  Book接口
    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersMapperCustom ordersMapperCustom;

    @Autowired
    private OrderitemMapperCustom orderitemMapperCustom;

    /**
     * 添加订单
     *
     * @param ordersCustom
     * @throws Exception
     */
    public void addOrders(OrdersCustom ordersCustom) throws Exception {
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersCustom, orders);
        ordersMapper.insert(orders);
        orderitemMapperCustom.insertOrderitems(ordersCustom.getOrderitemCustomList());
    }

    /**
     * 我的订单
     *
     * @param uid
     * @return
     */
    public List<OrdersCustom> myOrders(String uid) throws Exception {
        return ordersMapperCustom.findOrdersById(uid);
    }


    public OrdersCustom loadOrder(String oid) throws Exception {
        return ordersMapperCustom.loadOrder(oid);
    }


    /**
     * 确认收货
     *
     * @param oid
     * @throws Exception
     */
    public void confirm(String oid) throws Exception {
        int state = ordersMapperCustom.getStateByOid(oid);
        if (state != 3) throw new OrdersException("订单确认失败！");
        ordersMapperCustom.updateState(oid, 4);
    }

    /**
     * 支付
     *
     * @param oid
     * @throws Exception
     */
    public void pay(String oid) throws Exception {
        ordersMapperCustom.updateState(oid, 2);
    }

    /**
     * 所有订单
     *
     * @return
     * @throws Exception
     */
    public List<OrdersCustom> findOrderList() throws Exception {
        return ordersMapperCustom.findOrderList();
    }

    /**
     * 通过订单状态查询订单列表
     *
     * @param state
     * @return
     * @throws Exception
     */
    public List<OrdersCustom> findOrderListByState(String state) throws Exception {
        return ordersMapperCustom.findOrderListByState(state);
    }

    /**
     * 发货
     *
     * @param oid
     * @throws Exception
     */
    public void send(String oid) throws Exception {
        int state = ordersMapperCustom.getStateByOid(oid);
        if (state != 2) throw new OrdersException("发货失败");
        ordersMapperCustom.updateState(oid, 3);
    }
}
