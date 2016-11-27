package com.snrtqi.buy.controller;

import com.snrtqi.buy.pojo.CategoryCustom;
import com.snrtqi.buy.service.BookService;
import com.snrtqi.buy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分类管理Controller
 * Created by Gumo on 2016/11/19.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    //service类
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @ModelAttribute("bookTypes")
    public Map<String, String> getBookTypes() throws Exception{
        Map<String, String> bookTypes = new HashMap<String, String>();

        bookTypes.put("bookCustom.bname", "图书名");
        bookTypes.put("bookCustom.author", "作者");

        return bookTypes;

    }

    /**
     * 查询分类列表
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findCategoryList")
    public String findCategoryList(Model model) throws Exception {
        List<CategoryCustom> categoryCustomList = categoryService.findCategoryList();
        model.addAttribute("categoryList", categoryCustomList);
        return "left";
    }

}
