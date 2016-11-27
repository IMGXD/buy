package com.snrtqi.buy.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 *
 * @author Gumo
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    /**
     * @param ex 系统抛出的异常
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {

        ModelAndView modelAndView = new ModelAndView();
        CustomException customException = null;
        RegistException registException = null;
        LoginException loginException = null;
        AddCategoryException addCategoryException = null;
        UpdateCategoryException updateCategoryException = null;
        DeleteCategoryException deleteCategoryException = null;
        AdminLoginException adminLoginException = null;
        AddBookException addBookException = null;
        if (ex instanceof RegistException) {
            registException = ((RegistException) ex);
            // 错误信息
            String message = registException.getMessage();

            // 将错误信息传到页面
            modelAndView.addObject("message", message);

            // 指向到错误页面
            modelAndView.setViewName("user/regist");

            return modelAndView;
        } else if (ex instanceof LoginException) {
            loginException = ((LoginException) ex);
            // 错误信息
            String message = loginException.getMessage();

            // 将错误信息传到页面
            modelAndView.addObject("message", message);

            // 指向到错误页面
            modelAndView.setViewName("user/login");

            return modelAndView;
        } else if (ex instanceof AddCategoryException) {
            addCategoryException = ((AddCategoryException) ex);
            // 错误信息
            String message = addCategoryException.getMessage();

            // 将错误信息传到页面
            modelAndView.addObject("message", message);

            // 指向到错误页面
            modelAndView.setViewName("adminjsps/admin/category/add");

            return modelAndView;
        } else if (ex instanceof DeleteCategoryException) {
            deleteCategoryException = ((DeleteCategoryException) ex);
            // 错误信息
            String message = deleteCategoryException.getMessage();

            // 将错误信息传到页面
            modelAndView.addObject("message", message);

            // 指向到错误页面
            modelAndView.setViewName("adminjsps/admin/category/list");

            return modelAndView;
        } else if (ex instanceof UpdateCategoryException) {
            updateCategoryException = ((UpdateCategoryException) ex);
            // 错误信息
            String message = updateCategoryException.getMessage();

            // 将错误信息传到页面
            modelAndView.addObject("message", message);

            // 指向到错误页面
            modelAndView.setViewName("adminjsps/admin/category/edit");

            return modelAndView;
        } else if (ex instanceof AdminLoginException) {
            adminLoginException = ((AdminLoginException) ex);
            // 错误信息
            String message = adminLoginException.getMessage();

            // 将错误信息传到页面
            modelAndView.addObject("message", message);

            // 指向到错误页面
            modelAndView.setViewName("adminjsps/login");

            return modelAndView;
        } else if (ex instanceof AddBookException) {
            addBookException = ((AddBookException) ex);
            // 错误信息
            String message = addBookException.getMessage();

            // 将错误信息传到页面
            modelAndView.addObject("message", message);

            // 指向到错误页面
            modelAndView.setViewName("adminjsps/book/add");

            return modelAndView;
        } else {
            customException = new CustomException("未知错误");
            // 错误信息
            String message = customException.getMessage();

            // 将错误信息传到页面
            modelAndView.addObject("message", message);

            // 指向到错误页面
            modelAndView.setViewName("error");

            return modelAndView;
        }

    }

}
