package com.snrtqi.buy.mapper;

import com.snrtqi.buy.pojo.OrderitemCustom;

import java.util.List;

public interface OrderitemMapperCustom {

    /**
     * 插入订单条目
     *
     * @throws Exception
     */
    void insertOrderitems(List<OrderitemCustom> orderitemCustomList) throws Exception;

}