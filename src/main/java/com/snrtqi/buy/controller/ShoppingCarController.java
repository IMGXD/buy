package com.snrtqi.buy.controller;

import com.snrtqi.buy.pojo.BookCustom;
import com.snrtqi.buy.pojo.ShoppingCarCustom;
import com.snrtqi.buy.pojo.ShoppingCarItemCustom;
import com.snrtqi.buy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 购物车Controller
 * Created by Gumo on 2016/11/20.
 */
@Controller
@RequestMapping("/shoppingCar")
public class ShoppingCarController {

    //service类
    @Autowired
    private BookService bookService;

    @RequestMapping("/myCar")
    public String myCar() throws Exception {
        return "/cart/list";
    }

    /**
     * 添加条目
     * @param session
     * @return
     */
    @RequestMapping("/addShoppingCarItem")
    public String addShoppingCarItem(String bid, Integer count, HttpSession session) throws Exception {
        //  得到车
        ShoppingCarCustom shoppingCarCustom = (ShoppingCarCustom) session.getAttribute("shoppingCar");

        //  得到条目
        BookCustom bookCustom = bookService.loadBook(bid);
        ShoppingCarItemCustom shoppingCarItemCustom = new ShoppingCarItemCustom();
        shoppingCarItemCustom.setBookCustom(bookCustom);
        shoppingCarItemCustom.setCount(count);

        //  把条目添加到车中
        shoppingCarCustom.add(shoppingCarItemCustom);

        return "/cart/list";
    }

    /**
     * 清空条目
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/clearShoppingCarItem")
    public String clearShoppingCarItem(HttpSession session) throws Exception {
        //  得到车
        ShoppingCarCustom shoppingCarCustom = (ShoppingCarCustom) session.getAttribute("shoppingCar");

        //  执行clear方法
        shoppingCarCustom.clear();

        return "/cart/list";
    }

    /**
     * 删除条目
     * @param bid
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteShoppingCarItem")
    public String deleteShoppingCarItem(String bid, HttpSession session) throws Exception {
        //  得到车
        ShoppingCarCustom shoppingCarCustom = (ShoppingCarCustom) session.getAttribute("shoppingCar");

        //  执行clear方法
        shoppingCarCustom.delete(bid);

        return "/cart/list";
    }
}
