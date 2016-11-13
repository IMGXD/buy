package com.snrtqi.buy.controller;

import com.snrtqi.buy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gumo on 2016/9/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //service类
    @Autowired
    private UserService userService;

//    /**
//     * 查找所用用户控制器方法
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/findUser")
//    public ModelAndView findUser()throws Exception{
//        ModelAndView modelAndView = new ModelAndView();
//
//        //调用service方法得到用户列表
//        List<User> users = userService.findUser();
//        //将得到的用户列表内容添加到ModelAndView中
//        modelAndView.addObject("users",users);
//        //设置响应的jsp视图
//        modelAndView.setViewName("login");
//
//        return modelAndView;
//    }

    /**
     * 注册页面
     * @return
     * @throws Exception
     */
    @RequestMapping("/regist")
    public String regist() throws Exception {
        return "user/regist";
    }
}
