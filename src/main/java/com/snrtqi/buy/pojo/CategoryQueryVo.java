package com.snrtqi.buy.pojo;

/**
 * 分类信息的包装对象
 * Created by Gumo on 2016/11/12.
 */
public class CategoryQueryVo {

    // 分类信息
    private Category category;

    // 分类信息的扩展类
    private CategoryCustom categoryCustom;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryCustom getCategoryCustom() {
        return categoryCustom;
    }

    public void setCategoryCustom(CategoryCustom categoryCustom) {
        this.categoryCustom = categoryCustom;
    }
}
