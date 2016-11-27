package com.snrtqi.buy.mapper;

import com.snrtqi.buy.pojo.CategoryCustom;

import java.util.List;

public interface CategoryMapperCustom {

    /**
     * 查询分类列表
     *
     * @return
     * @throws Exception
     */
    List<CategoryCustom> findCategoryList() throws Exception;

    /**
     * 通过分类名查找分类
     * @param cname
     * @return
     * @throws Exception
     */
    CategoryCustom findCategoyByCname(String cname) throws Exception;
}