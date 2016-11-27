package com.snrtqi.buy.controller;

import com.snrtqi.buy.pojo.BookCustom;
import com.snrtqi.buy.pojo.BookQueryVo;
import com.snrtqi.buy.pojo.CategoryCustom;
import com.snrtqi.buy.service.BookService;
import com.snrtqi.buy.service.CategoryService;
import com.snrtqi.buy.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

/**
 * 管理员图书管理Controller
 * Created by Gumo on 2016/11/21.
 */
@Controller
@RequestMapping("/adminBook")
public class AdminBookController {

    //service类
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询图书列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findBookList")
    public ModelAndView findBookList() throws Exception {

        //  调用service方法查找图书列表
        List<BookCustom> bookCustomList = bookService.findBookList(null);

        //  定义modelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bookList", bookCustomList);
        modelAndView.setViewName("adminjsps/admin/book/list");

        //  返回modelAndView
        return modelAndView;
    }

    /**
     * 加载图书
     *
     * @param bid
     * @return
     * @throws Exception
     */
    @RequestMapping("/loadBook")
    public ModelAndView loadBook(String bid) throws Exception {
        //  调用service方法加载图书
        BookCustom bookCustom = bookService.loadBook(bid);

        //  调用service方法得到分类信息列表
        List<CategoryCustom> categoryCustomList = categoryService.findCategoryList();

        //  定义modelAndView
        ModelAndView modelAndView = new ModelAndView();

        //  将想要查询的图书和分类列表放入request域中
        modelAndView.addObject("book", bookCustom);
        modelAndView.addObject("categoryList", categoryCustomList);

        //  设置视图
        modelAndView.setViewName("adminjsps/admin/book/desc");

        //  返回modelAndView
        return modelAndView;
    }

    /**
     * 添加图书前加载分类信息列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/addPre")
    public ModelAndView addPre() throws Exception {

        //  调用service方法得到分类信息列表
        List<CategoryCustom> categoryCustomList = categoryService.findCategoryList();

        //  定义modelAndView
        ModelAndView modelAndView = new ModelAndView();

        //  将想要查询的图书和分类列表放入request域中
        modelAndView.addObject("categoryList", categoryCustomList);

        //  设置视图
        modelAndView.setViewName("adminjsps/admin/book/add");

        //  返回modelAndView
        return modelAndView;
    }

    @RequestMapping("/addBook")
    public String addBook(BookQueryVo bookQueryVo,
                          MultipartFile book_pic,
                          @ModelAttribute("bookCustom.bname") String bname) throws Exception {
        //  原始名称
        String originalFilename = book_pic.getOriginalFilename();

        //  上传图片
        if (book_pic != null && originalFilename != null && originalFilename.length() > 0) {
            //  存储图片的路径
            String savePath = "F:\\develop\\upload\\book_img\\";

            //  新的图片名称
            String newFileName = CommonUtils.uuid() + originalFilename.substring(originalFilename.lastIndexOf("."));

            //  新图片
            File newFile = new File(savePath, newFileName);

            //  将内存中的数据写入磁盘
            book_pic.transferTo(newFile);

            //  新的图片地址封装到对象中
            bookQueryVo.getBookCustom().setImage("book_img/" + newFileName);
        }


        //  设置bid
        bookQueryVo.getBookCustom().setBid(CommonUtils.uuid());

        //  设置是否删除标记
        bookQueryVo.getBookCustom().setDel(false);

        bookService.addBook(bname, bookQueryVo);

        //  返回modelAndView
        return "redirect:findBookList";
    }

    /**
     * 删除图书
     *
     * @param bid
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(String bid) throws Exception {
        //  调用service方法删除图书
        bookService.delete(bid);

        return "redirect:findBookList";
    }

    /**
     * 编辑图书
     *
     * @param bookCustom
     * @return
     * @throws Exception
     */
    @RequestMapping("/edit")
    public String edit(BookCustom bookCustom) throws Exception {
        //  调用service方法加载图书
        bookService.updateBook(bookCustom);

        //  返回modelAndView
        return "redirect:findBookList";
    }

}
