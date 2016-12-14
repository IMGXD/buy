package com.snrtqi.buy.service.impl;

import com.snrtqi.buy.pojo.CategoryCustom;
import com.snrtqi.buy.pojo.CategoryQueryVo;
import com.snrtqi.buy.service.CategoryService;
import com.snrtqi.buy.util.CommonUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Gumo on 2016/12/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class CategoryServiceImplTest {

    @Inject
    CategoryService categoryService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addCategory() throws Exception {
        CategoryCustom categoryCustom = new CategoryCustom();
        categoryCustom.setCid(CommonUtils.uuid());
        categoryCustom.setCname("javaee");
        CategoryQueryVo categoryQueryVo = new CategoryQueryVo();
        categoryQueryVo.setCategoryCustom(categoryCustom);
        categoryService.addCategory("javaee", categoryQueryVo);
    }

    @Test
    public void updateCategory() throws Exception {
        CategoryCustom categoryCustom = new CategoryCustom();
        categoryCustom.setCid(CommonUtils.uuid());
        categoryCustom.setCname("javaSSSe");
        CategoryQueryVo categoryQueryVo = new CategoryQueryVo();
        categoryQueryVo.setCategoryCustom(categoryCustom);
        categoryService.updateCategory("1", categoryQueryVo);
    }

    @Test
    public void deleteCategory() throws Exception {
        categoryService.deleteCategory("1");
    }

}