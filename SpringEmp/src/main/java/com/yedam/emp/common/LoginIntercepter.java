package com.yedam.emp.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;


public class LoginIntercepter implements HandlerInterceptor {

	@Override //controller 실행전
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginid");
		if(id==null) {
			response.sendRedirect("login");
			return false;
		}
		return true;
	}



}
