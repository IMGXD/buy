package com.snrtqi.buy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主界面Controller
 * Created by Gumo on 2016/11/13.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/main")
    public String main() throws Exception {
        return "main";
    }

    @RequestMapping("/top")
    public String top() throws Exception {
        return "top";
    }

    @RequestMapping("/left")
    public String left() throws Exception {
        return "left";
    }

    @RequestMapping("/body")
    public String body() throws Exception {
        return "body";
    }

    @RequestMapping("/adminIndex")
    public String adminIndex() throws Exception {
        return "adminjsps/admin/index";
    }

    @RequestMapping("/adminMain")
    public String adminMain() throws Exception {
        return "adminjsps/admin/main";
    }

    @RequestMapping("/adminTop")
    public String adminTop() throws Exception {
        return "adminjsps/admin/top";
    }

    @RequestMapping("/adminLeft")
    public String adminLeft() throws Exception {
        return "adminjsps/admin/left";
    }

    @RequestMapping("/adminBody")
    public String adminBody() throws Exception {
        return "adminjsps/admin/body";
    }
}
