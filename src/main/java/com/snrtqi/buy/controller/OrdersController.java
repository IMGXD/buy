package com.snrtqi.buy.controller;

import com.snrtqi.buy.pojo.*;
import com.snrtqi.buy.service.OrdersService;
import com.snrtqi.buy.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Gumo on 2016/11/20.
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    //service类
    @Autowired
    private OrdersService ordersService;

    /**
     * 添加订单
     *
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/addOrders")
    public String addOrders(HttpSession session, Model model) throws Exception {
        /*
            获取车
         */
        ShoppingCarCustom shoppingCarCustom = (ShoppingCarCustom) session.getAttribute("shoppingCar");

        /*
            把shoppingCarCustom转换成Orders对象
         */
        OrdersCustom ordersCustom = new OrdersCustom();

        ordersCustom.setOid(CommonUtils.uuid());
        ordersCustom.setOrdertime(new Date());
        ordersCustom.setState((short) 1);
        UserCustom user = (UserCustom) session.getAttribute("session_user");
        ordersCustom.setUid(user.getUid());
        ordersCustom.setTotal(shoppingCarCustom.getTotal());

        /*
            创建订单条目类
         */
        List<OrderitemCustom> orderitemCustomList = new ArrayList<OrderitemCustom>();
        for (ShoppingCarItemCustom shoppingCarItemCustom :
                shoppingCarCustom.getShoppingCartItems()) {
            OrderitemCustom oi = new OrderitemCustom();

            oi.setIid(CommonUtils.uuid());

            oi.setCount(shoppingCarItemCustom.getCount());

            oi.setSubtotal(shoppingCarItemCustom.getSubtotal());

            oi.setOid(ordersCustom.getOid());

            oi.setBid(shoppingCarItemCustom.getBookCustom().getBid());

            oi.setBookCustom(shoppingCarItemCustom.getBookCustom());

            orderitemCustomList.add(oi);
        }

        ordersCustom.setOrderitemCustomList(orderitemCustomList);

        ordersService.addOrders(ordersCustom);

        model.addAttribute("order", ordersCustom);
        ((ShoppingCarCustom) session.getAttribute("shoppingCar")).clear();

        return "order/desc";
    }

    @RequestMapping("/myOrders")
    public ModelAndView myOrders(HttpSession session) throws Exception {
        //  从session得到当前用户，再获取其uid
        UserCustom userCustom = (UserCustom) session.getAttribute("session_user");

        //  用uid调用service方法，获取该用户的所有订单List<OrdersCustom>
        List<OrdersCustom> ordersCustomList = ordersService.myOrders(userCustom.getUid());

        //  订单列表保存到request域中，之后转发到order/list

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderList", ordersCustomList);
        modelAndView.setViewName("order/list");

        return modelAndView;
    }
}
