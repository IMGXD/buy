package com.snrtqi.buy.service;

import com.snrtqi.buy.pojo.BookCustom;
import com.snrtqi.buy.pojo.BookQueryVo;

import java.util.List;

/**
 * Created by Gumo on 2016/11/19.
 */
public interface BookService {

    /**
     * 查询图书列表
     *
     * @param bookQueryVo
     * @return
     * @throws Exception
     */
    List<BookCustom> findBookList(BookQueryVo bookQueryVo) throws Exception;

    /**
     * 加载图书
     *
     * @param bid
     * @return
     * @throws Exception
     */
    BookCustom loadBook(String bid) throws Exception;

    /**
     * 添加图书
     *
     * @param bname
     * @param bookQueryVo
     * @throws Exception
     */
    void addBook(String bname, BookQueryVo bookQueryVo) throws Exception;
}
