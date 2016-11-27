package com.snrtqi.buy.controller;

import com.snrtqi.buy.pojo.BookCustom;
import com.snrtqi.buy.pojo.BookQueryVo;
import com.snrtqi.buy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 图书管理Controller
 * Created by Gumo on 2016/11/19.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    //service类
    @Autowired
    private BookService bookService;

    /**
     * 查询分类列表
     *
     * @param bookQueryVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findBookList", produces="text/html;charset=UTF-8")
    public ModelAndView findBookList(BookQueryVo bookQueryVo) throws Exception {

        //  调用service方法查找图书列表
        List<BookCustom> bookCustomList = bookService.findBookList(bookQueryVo);

        //  定义modelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("bookList", bookCustomList);
        modelAndView.setViewName("book/list");

        //  返回modelAndView
        return modelAndView;
    }

    /**
     * @param bid
     * @return
     * @throws Exception
     */
    @RequestMapping("/loadBook")
    public ModelAndView loadBook(String bid) throws Exception {
        //  调用service方法加载图书
        BookCustom bookCustom = bookService.loadBook(bid);

        //  定义modelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", bookCustom);
        modelAndView.setViewName("book/desc");

        //  返回modelAndView
        return modelAndView;
    }

}