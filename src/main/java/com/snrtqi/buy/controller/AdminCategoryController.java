package com.snrtqi.buy.controller;

import com.snrtqi.buy.pojo.CategoryCustom;
import com.snrtqi.buy.pojo.CategoryQueryVo;
import com.snrtqi.buy.service.CategoryService;
import com.snrtqi.buy.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员分类管理Controller
 * Created by Gumo on 2016/11/19.
 */
@Controller
@RequestMapping("/adminCategory")
public class AdminCategoryController {

    //service类
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询分类信息列表
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findCategoryList")
    public String findCategoryList(Model model) throws Exception {
        List<CategoryCustom> categoryCustomList = categoryService.findCategoryList();
        model.addAttribute("categoryList", categoryCustomList);
        return "adminjsps/admin/category/list";
    }

    /**
     * 添加分类信息页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/addCategory")
    public String addCategory() throws Exception {
        return "adminjsps/admin/category/add";
    }

    /**
     * 添加分类信息提交
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/addCategorySubmit")
    public String addCategorySubmit(@ModelAttribute("categoryCustom.cname") String cname,
                                    CategoryQueryVo categoryQueryVo,
                                    Model model) throws Exception {
        /*
            封装数据
         */
        categoryQueryVo.getCategoryCustom().setCid(CommonUtils.uuid());

        /*
            输入校验（暂未用springmvc的校验）
         */
        //  定义Map
        Map<String, String> errors = new HashMap<String, String>();

        //  校验用户名
        if (cname == null || cname.trim().isEmpty()) {
            errors.put("cname", "分类名不能为空！");
        } else if (cname.length() < 3 || cname.length() > 10) {
            errors.put("cname", "分类名长度必须在3-10之间！");
        }

        //  判断是否存在错误信息
        if (errors.size() > 0) {
            model.addAttribute("errors", errors);
            model.addAttribute("category", categoryQueryVo.getCategoryCustom());
            return "adminjsps/admin/category/add";
        }

        /*
            调用service的addCategory方法
         */
        categoryService.addCategory(cname, categoryQueryVo);

        /*
            成功，转到分类列表页面
         */
        model.addAttribute("message", "恭喜，添加分类成功！");
        return "redirect:findCategoryList";
    }

    /**
     * 修改分类信息页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/editCategory")
    public String editCategory(String cid, Model model) throws Exception {
        CategoryCustom categoryCustom = categoryService.findCategoryById(cid);
        model.addAttribute("category", categoryCustom);
        return "adminjsps/admin/category/edit";
    }

    /**
     * 修改分类信息提交
     *
     * @param cid
     * @param categoryQueryVo
     * @return
     * @throws Exception
     */
    @RequestMapping("/editCategorySubmit")
    public String editCategorySubmit(@ModelAttribute("categoryCustom.cid") String cid,
                                     CategoryQueryVo categoryQueryVo,
                                     Model model) throws Exception {
        /*
            输入校验（暂未用springmvc的校验）
         */
        //  定义Map
        Map<String, String> errors = new HashMap<String, String>();

        //  获取分类名称
        String cname = categoryQueryVo.getCategoryCustom().getCname();

        //  校验用户名
        if (cname == null || cname.trim().isEmpty()) {
            errors.put("cname", "分类名不能为空！");
        } else if (cname.length() < 3 || cname.length() > 10) {
            errors.put("cname", "分类名长度必须在3-10之间！");
        }

        //  判断是否存在错误信息
        if (errors.size() > 0) {
            model.addAttribute("errors", errors);
            model.addAttribute("category", categoryQueryVo.getCategoryCustom());
            return "adminjsps/admin/category/edit";
        }
        categoryService.updateCategory(cid, categoryQueryVo);
        return "redirect:findCategoryList";
    }

    /**
     * 删除分类信息提交
     *
     * @param cid
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteCategorySubmit")
    public String deleteCategorySubmit(String cid) throws Exception {
        categoryService.deleteCategory(cid);
        return "redirect:findCategoryList";
    }
}
