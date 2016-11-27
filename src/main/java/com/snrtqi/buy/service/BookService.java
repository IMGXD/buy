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

    /**
     * 根据分类查询图书列表
     *
     * @param cid
     * @return
     * @throws Exception
     */
    List<BookCustom> findBookListByCid(String cid) throws Exception;

    /**
     * 通过图书名称或作者名称模糊查找图书
     *
     * @param bname
     * @return
     * @throws Exception
     */
    List<BookCustom> findBooksByBnameOrAuthor(String bname, String author) throws Exception;

    /**
     * 删除图书
     *
     * @param bid
     * @throws Exception
     */
    void delete(String bid) throws Exception;

    /**
     * 更新图书信息
     *
     * @param bookCustom
     */
    void updateBook(BookCustom bookCustom);
}
