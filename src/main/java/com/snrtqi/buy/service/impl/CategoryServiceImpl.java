package com.snrtqi.buy.service.impl;

import com.snrtqi.buy.exception.AddCategoryException;
import com.snrtqi.buy.exception.DeleteCategoryException;
import com.snrtqi.buy.exception.UpdateCategoryException;
import com.snrtqi.buy.mapper.BookMapperCustom;
import com.snrtqi.buy.mapper.CategoryMapper;
import com.snrtqi.buy.mapper.CategoryMapperCustom;
import com.snrtqi.buy.pojo.Category;
import com.snrtqi.buy.pojo.CategoryCustom;
import com.snrtqi.buy.pojo.CategoryQueryVo;
import com.snrtqi.buy.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Gumo on 2016/11/19.
 */
public class CategoryServiceImpl implements CategoryService {

    //  Category接口
    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BookMapperCustom bookMapperCustom;

    /**
     * 查找分类列表
     *
     * @return
     * @throws Exception
     */
    public List<CategoryCustom> findCategoryList() throws Exception {
        System.out.println("findCategoryList");
        return categoryMapperCustom.findCategoryList();
    }

    /**
     * 添加分类
     *
     * @param cname
     * @param categoryQueryVo
     * @throws Exception
     */
    public void addCategory(String cname, CategoryQueryVo categoryQueryVo) throws Exception {
        CategoryCustom findCategory = categoryMapperCustom.findCategoyByCname(cname);
        if (findCategory != null) {
            throw new AddCategoryException("分类名已存在");
        }

        Category category = new Category();
        BeanUtils.copyProperties(categoryQueryVo.getCategoryCustom(), category);
        categoryMapper.insert(category);
    }

    /**
     * 根据id查询分类
     *
     * @param cid
     * @return
     * @throws Exception
     */
    public CategoryCustom findCategoryById(String cid) throws Exception {
        Category category = categoryMapper.selectByPrimaryKey(cid);
        CategoryCustom categoryCustom = new CategoryCustom();
        BeanUtils.copyProperties(category, categoryCustom);
        return categoryCustom;
    }

    /**
     * 更新分类信息
     *
     * @param cid
     * @param categoryQueryVo
     * @throws Exception
     */
    public void updateCategory(String cid, CategoryQueryVo categoryQueryVo) throws Exception {
        if (cid == null) {
            throw new UpdateCategoryException("id为空");
        }
        categoryQueryVo.getCategoryCustom().setCid(cid);
        categoryMapper.updateByPrimaryKeySelective(categoryQueryVo.getCategoryCustom());
    }

    /**
     * 删除分类信息
     *
     * @param cid
     * @throws Exception
     */
    public void deleteCategory(String cid) throws Exception {
        Integer count = bookMapperCustom.getCountByCid(cid);
        if(count > 0) throw new DeleteCategoryException("该分类下还有图书，不能删除！");
        categoryMapper.deleteByPrimaryKey(cid);
    }
}
