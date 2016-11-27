package com.snrtqi.buy.pojo;

/**
 * 图书的包装类型
 * Created by Gumo on 2016/11/19.
 */
public class BookQueryVo {

    // 图书的扩展类
    private BookCustom bookCustom;

    public BookCustom getBookCustom() {
        return bookCustom;
    }

    public void setBookCustom(BookCustom bookCustom) {
        this.bookCustom = bookCustom;
    }
}
