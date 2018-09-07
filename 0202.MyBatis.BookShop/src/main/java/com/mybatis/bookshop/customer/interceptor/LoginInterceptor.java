package com.mybatis.bookshop.customer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mybatis.bookshop.customer.model.Customer;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		System.out.println("LoginInterceptor: "+action);
		if(action.equals("insertOrder") ||
			action.equals("orderList")) {
			Customer loginInfo = (Customer)request.getSession().getAttribute("loginInfo");
			if(loginInfo == null) {
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/loginForm");
//				dispatcher.forward(request, response);
				response.sendRedirect("/bookshop/customer/loginForm");
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}
	
}
