package com.snrtqi.buy.pojo;

/**
 * 订单条目的扩展类
 * Created by Gumo on 2016/11/12.
 */
public class OrderitemCustom extends Orderitem {

    //  图书信息扩展类
    private BookCustom bookCustom;

    public BookCustom getBookCustom() {
        return bookCustom;
    }

    public void setBookCustom(BookCustom bookCustom) {
        this.bookCustom = bookCustom;
    }
}
