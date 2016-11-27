package com.snrtqi.buy.controller;

import com.snrtqi.buy.pojo.AdminCustom;
import com.snrtqi.buy.pojo.AdminQueryVo;
import com.snrtqi.buy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理员管理Controller
 * Created by Gumo on 2016/9/19.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    //service类
    @Autowired
    private AdminService adminService;

    /**
     * 登录页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login() throws Exception {
        return "adminjsps/login";
    }

    /**
     * 登录提交
     *
     * @param username
     * @param adminQueryVo
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/loginSubmit")
    public String loginSubmit(@ModelAttribute("adminCustom.username") String username,
                              AdminQueryVo adminQueryVo,
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
        String password = adminQueryVo.getAdminCustom().getPassword();
        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if (password.length() < 3 || password.length() > 10) {
            errors.put("password", "密码长度必须在3-10之间！");
        }

        //  判断是否存在错误信息
        if (errors.size() > 0) {
            model.addAttribute("errors", errors);
            model.addAttribute("admin", adminQueryVo.getAdminCustom());
            return "adminjsps/login";
        }

        /*
            调用service的login方法
         */
        AdminCustom adminCustom = adminService.login(username, adminQueryVo);

        /*
            将user放入session
         */
        //  判断session是否为null
        if (session.getAttribute("session_admin") != null) {
            session.invalidate();
        }

        //  将user放入session
        session.setAttribute("session_admin", adminCustom);

        /*
            成功，转到主页
         */
        return "redirect:/home/adminIndex";
    }

    /**
     * 注销功能
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("session_admin") != null) {
            session.invalidate();
        }
        return "redirect:login";
    }

}
