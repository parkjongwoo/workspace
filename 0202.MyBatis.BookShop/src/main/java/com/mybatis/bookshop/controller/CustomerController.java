package com.mybatis.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mybatis.bookshop.model.Customer;
import com.mybatis.bookshop.service.BookShopService;

/**
 * session에 저장할 model의 attribute를 \@SessionAttributes 로 선언한다.
 * model에 저장하는 동일한 key의 데이터를 Session에 저장 해준다.
 * 주의 ::::::::::
 * HttpSession 객체에 직접 attribute저장시 SessionStatus에 의한 제어가 불가능하다.
 * 관리 주체가 달라지는 것 같으므로 공부가 필요하다.
 * @author goott3-4
 *
 */
@Controller
@SessionAttributes("loginInfo") 
public class CustomerController {
	
	@Autowired
	BookShopService bookShopService;
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm() {
		
		return "loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	
	public String login(Customer formInfo,Model model) {
		
		Customer loginInfo = bookShopService.getMatchedLoginInfoCnt(formInfo);		
		if(loginInfo!=null) {
			model.addAttribute("loginInfo", loginInfo);
		}
		return "forward:/index.jsp";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/index.jsp";
	}
}
