package com.snrtqi.buy.controller;

import com.snrtqi.buy.pojo.OrdersCustom;
import com.snrtqi.buy.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Gumo on 2016/11/20.
 */
@Controller
@RequestMapping("/adminOrders")
public class AdminOrdersController {

    //service类
    @Autowired
    private OrdersService ordersService;

    /**
     * 查询订单列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findOrderList")
    public ModelAndView findOrderList() throws Exception {

        //  调用service方法查找订单列表
        List<OrdersCustom> ordersCustomList = ordersService.findOrderList();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderList", ordersCustomList);
        modelAndView.setViewName("adminjsps/admin/order/list");

        return modelAndView;
    }

    /**
     * 通过订单状态查询订单列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findOrderListByState")
    public ModelAndView findOrderListByState(String state) throws Exception {

        //  调用service方法查找订单列表
        List<OrdersCustom> ordersCustomList = ordersService.findOrderListByState(state);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderList", ordersCustomList);
        modelAndView.setViewName("adminjsps/admin/order/list");

        return modelAndView;
    }

    /**
     * 发货
     *
     * @param oid
     * @return
     * @throws Exception
     */
    @RequestMapping("/send")
    public ModelAndView send(String oid) throws Exception {

        ordersService.send(oid);

        //  订单列表保存到request域中，之后转发到success

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "已发货");
        modelAndView.setViewName("success");

        return modelAndView;
    }

}
