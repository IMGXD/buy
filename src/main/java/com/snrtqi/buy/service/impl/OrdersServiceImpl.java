package com.snrtqi.buy.service.impl;

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
    public List<OrdersCustom> myOrders(String uid) {
        return ordersMapperCustom.findOrdersById(uid);
    }
}
