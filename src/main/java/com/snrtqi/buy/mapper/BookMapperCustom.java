package com.snrtqi.buy.mapper;

import com.snrtqi.buy.pojo.BookCustom;
import com.snrtqi.buy.pojo.BookQueryVo;

import java.util.List;

public interface BookMapperCustom {


    /**
     * 查询图书列表
     *
     * @param bookQueryVo
     * @return
     * @throws Exception
     */
    List<BookCustom> findBookList(BookQueryVo bookQueryVo) throws Exception;


    /**
     * 根据分类查询图书列表
     *
     * @param cid
     * @return
     * @throws Exception
     */
    List<BookCustom> findBookListByCid(String cid) throws Exception;

    /**
     * 查询指定分类下的图书本数
     *
     * @param cid
     * @return
     * @throws Exception
     */
    Integer getCountByCid(String cid) throws Exception;

    /**
     * 通过图书名称查找图书
     *
     * @param bname
     * @return
     * @throws Exception
     */
    BookCustom findBookByBname(String bname) throws Exception;

    /**
     * 通过图书名称模糊查找图书
     *
     * @param bname
     * @return
     * @throws Exception
     */
    List<BookCustom> findBooksByBname(String bname) throws Exception;

    /**
     * 通过作者名称模糊查找图书
     *
     * @param author
     * @return
     * @throws Exception
     */
    List<BookCustom> findBooksByAuthor(String author) throws Exception;

    /**
     * 删除图书
     *
     * @param bid
     * @throws Exception
     */
    void delete(String bid) throws Exception;
}