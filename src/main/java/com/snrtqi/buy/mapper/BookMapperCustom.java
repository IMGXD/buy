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
     * 查询指定分类下的图书本数
     *
     * @param cid
     * @return
     * @throws Exception
     */
    Integer getCountByCid(String cid) throws Exception;

    /**
     * 通过图书名称查找图书
     * @param bname
     * @return
     * @throws Exception
     */
    BookCustom findBookByBname(String bname) throws Exception;
}