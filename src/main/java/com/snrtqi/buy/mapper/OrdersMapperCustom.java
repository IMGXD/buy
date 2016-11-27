package com.snrtqi.buy.mapper;

import com.snrtqi.buy.pojo.OrdersCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapperCustom {

    /**
     * 我的订单
     *
     * @param uid
     * @return
     */
    List<OrdersCustom> findOrdersById(String uid) throws Exception;

    /**
     * 加载单个订单
     *
     * @param oid
     * @return
     * @throws Exception
     */
    OrdersCustom loadOrder(String oid) throws Exception;

    /**
     * 通过oid查询订单状态
     *
     * @param oid
     * @return
     * @throws Exception
     */
    int getStateByOid(String oid) throws Exception;

    /**
     * 修改订单状态
     *
     * @throws Exception
     */
    void updateState(@Param("oid") String oid, @Param("state") Integer state) throws Exception;

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
}