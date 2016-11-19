package com.snrtqi.buy.controller;

import com.snrtqi.buy.pojo.UserCustom;
import com.snrtqi.buy.pojo.UserQueryVo;
import com.snrtqi.buy.service.UserService;
import com.snrtqi.buy.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gumo on 2016/9/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //service类
    @Autowired
    private UserService userService;

    /**
     * 注册页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/regist")
    public String regist() throws Exception {
        return "user/regist";
    }

    /**
     * 注册提交
     *
     * @param username
     * @param email
     * @param userQueryVo
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/registSubmit")
    public String registSubmit(@ModelAttribute("userCustom.username") String username,
                               @ModelAttribute("userCustom.email") String email,
                               UserQueryVo userQueryVo,
                               Model model) throws Exception {
        /*
            封装数据
         */
        userQueryVo.getUserCustom().setUid(CommonUtils.uuid());
        userQueryVo.getUserCustom().setCode(CommonUtils.uuid() + CommonUtils.uuid());
        userQueryVo.getUserCustom().setState(true);

        /*
            输入校验（暂未用springmvc的校验）
         */
        //  定义Map
        Map<String, String> errors = new HashMap<String, String>();

        //  校验用户名
        if (username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能为空！");
        } else if (username.length() < 3 || username.length() > 10) {
            errors.put("username", "用户名长度必须在3-10之间！");
        }

        //  校验密码
        String password = userQueryVo.getUserCustom().getPassword();
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if (password.length() < 3 || password.length() > 10) {
            errors.put("password", "密码长度必须在3-10之间！");
        }

        //  校验邮箱
        if (email == null || email.trim().isEmpty()) {
            errors.put("email", "email不能为空！");
        } else if (!email.matches("\\w+@\\w+\\.\\w+")) {
            errors.put("email", "email格式错误");
        }

        //  判断是否存在错误信息
        if (errors.size() > 0) {
            model.addAttribute("errors", errors);
            model.addAttribute("user", userQueryVo.getUserCustom());
            return "forward:regist";
        }

        /*
            调用service的regist方法
         */
        userService.regist(username, email, userQueryVo);

        /*
            成功，转到注册成功页面
         */
        model.addAttribute("message", "恭喜，注册成功！");
        return "message";
    }

    /**
     * 登录页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login() throws Exception {
        return "user/login";
    }

    /**
     * 登录提交
     *
     * @param username
     * @param userQueryVo
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/loginSubmit")
    public String loginSubmit(@ModelAttribute("userCustom.username") String username,
                              UserQueryVo userQueryVo,
                              Model model,
                              HttpSession session) throws Exception {
        /*
            输入校验（暂未用springmvc的校验）
         */
        //  定义Map
        Map<String, String> errors = new HashMap<String, String>();

        //  校验用户名
        if (username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能为空！");
        } else if (username.length() < 3 || username.length() > 10) {
            errors.put("username", "用户名长度必须在3-10之间！");
        }

        //  校验密码
        String password = userQueryVo.getUserCustom().getPassword();
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if (password.length() < 3 || password.length() > 10) {
            errors.put("password", "密码长度必须在3-10之间！");
        }

        //  判断是否存在错误信息
        if (errors.size() > 0) {
            model.addAttribute("errors", errors);
            model.addAttribute("user", userQueryVo.getUserCustom());
            return "forward:login";
        }

        /*
            调用service的regist方法
         */
        UserCustom userCustom = userService.login(username, userQueryVo);

        /*
            将user放入session
         */
        //  判断session是否为null
        if (session.getAttribute("session_user") != null) {
            session.invalidate();
        }

        //  将user放入session
        session.setAttribute("session_user", userCustom);

        /*
            成功，转到主页
         */
        return "redirect:/home/toHome";
    }

    /**
     * 注销功能
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("session_user") != null) {
            session.invalidate();
        }
        return "redirect:/home/toHome";
    }
}
