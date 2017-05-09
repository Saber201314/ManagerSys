package com.manager.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.manager.entitys.crawlerUser;

public class LoginInterceptor implements HandlerInterceptor {

	// @Autowired
	// private UserService userService;
	// @Value("SSO_LOGIN_URL")
	// private String SSO_LOGIN_URL;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("userName");
		System.out.println(username);
		// 判断是否为公开地址
		String url = request.getRequestURL().toString();
		System.out.println(url);
		if (url.contains("index")) {
			return true;// 是公开地址则放行
		}
		// 判断用户是否登录
		else if (username != null) {
			return true;
		} else {
			// 不是公开地址则重定向到登录页面
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);
			return false;
		}
	}

	// 返回modelAndView之前执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("拦截器：postHandle");
		System.out.println(request.getRequestURI());
		System.out.println("-------------------------\n");
	}

	// 执行Handler完成执行此方法
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("拦截器：afterCompletion");
		System.out.println(request.getRequestURI());
		System.out.println("-------------------------\n");
	}
}