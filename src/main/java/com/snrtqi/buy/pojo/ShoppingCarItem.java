package com.snrtqi.buy.pojo;

import java.math.BigDecimal;

/**
 * 购物车条目类
 * Created by Gumo on 2016/11/20.
 */
public class ShoppingCarItem {

    //  商品
    private BookCustom bookCustom;

    //  数量
    private int count;

    //  小计方法
    public double getSubtotal() {
        BigDecimal d1 = new BigDecimal(count);
        return bookCustom.getPrice().multiply(d1).doubleValue();
    }

    public BookCustom getBookCustom() {
        return bookCustom;
    }

    public void setBookCustom(BookCustom bookCustom) {
        this.bookCustom = bookCustom;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
