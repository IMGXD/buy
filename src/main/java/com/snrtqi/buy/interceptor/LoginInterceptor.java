package com.snrtqi.buy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录认证拦截器
 * 
 * @author Gumo
 *
 */
// 基于AOP
public class LoginInterceptor implements HandlerInterceptor {

	// 在进入Handler方法之前执行
	// 用于身份认证、身份授权
	// 比如身份认证，如果认证不通过表示当前用户没有登录，需要此方法拦截不再向下执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 获取请求的url
		String url = request.getRequestURI();
		// 判断url是否是公开地址（实际使用时将公开地址配置在配置文件中）
		// 这里公开地址是登录提交的地址
		if (url.indexOf("login.action") >= 0) {
			// 如果进行登录提交，放行
			return true;
		}
		
		// 判断session
		HttpSession session = request.getSession();
		// 从session中取出用户身份信息
		String username = (String) session.getAttribute("username");
		
		if (username != null) {
			//身份存在，放行
			return true;
		}
		
		
		// 执行到这里表示用户身份需要认证，跳转登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		// return false表示拦截，不向下执行
		// return true表示执行
		return false;
	}

	// 进入Handler方法之后，返回modelAndView之前执行
	// 应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一指定视图
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("postHandle");

	}

	// 执行Handler完成执行此方法
	// 应用场景：统一异常处理，统一日志处理
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("afterCompletion");

	}

}
