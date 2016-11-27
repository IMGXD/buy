package com.snrtqi.buy.service;

import com.snrtqi.buy.pojo.CategoryCustom;
import com.snrtqi.buy.pojo.CategoryQueryVo;

import java.util.List;

/**
 * Created by Gumo on 2016/11/19.
 */
public interface CategoryService {

    /**
     * 查找分类列表
     *
     * @return
     * @throws Exception
     */
    List<CategoryCustom> findCategoryList() throws Exception;

    /**
     * 添加分类
     *
     * @param cname
     * @param categoryQueryVo
     * @throws Exception
     */
    void addCategory(String cname, CategoryQueryVo categoryQueryVo) throws Exception;

    /**
     * 根据id查询分类
     *
     * @param cid
     * @return
     * @throws Exception
     */
    CategoryCustom findCategoryById(String cid) throws Exception;

    /**
     * 更新分类信息
     *
     * @param cid
     * @param categoryQueryVo
     * @throws Exception
     */
    void updateCategory(String cid, CategoryQueryVo categoryQueryVo) throws Exception;

    /**
     * 删除分类信息
     * @param cid
     * @throws Exception
     */
    void deleteCategory(String cid) throws Exception;
}
