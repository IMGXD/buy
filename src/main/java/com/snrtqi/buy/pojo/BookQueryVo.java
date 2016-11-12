package com.snrtqi.buy.pojo;

/**
 * 图书信息的包装对象
 * Created by Gumo on 2016/11/12.
 */
public class BookQueryVo {

    // 图书信息
    private Book book;

    // 图书扩展类
    private BookCustom bookCustom;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookCustom getBookCustom() {
        return bookCustom;
    }

    public void setBookCustom(BookCustom bookCustom) {
        this.bookCustom = bookCustom;
    }
}
