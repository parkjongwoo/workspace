package com.mappingtest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mappingtest.model.Customer;


/**
 * class에 requestMapping을 *로 정의하면 해당 패스를 포함한 모든 페이지 처리
 * method에 한번더 requestMapping 선언해서 정확한 주소로 완성.
 * 관련테이블,뷰 / 기능(crud,page) 등등 분류 가능할듯.
 * @author goott3-4
 *
 */
@Controller
@RequestMapping("/viewEx/*")
public class ViewResolverTestController {
	
	@Autowired
	private ApplicationContext context;
	public void setServletContext(ApplicationContext servletContext) {
	    this.context = servletContext;
	}
	
	@RequestMapping(value="/v01", method=RequestMethod.GET)
	public String view01(Model model) {
		model.addAttribute("requestMethodName", "view01()");
		return "viewEx/v01";
	}
	
	/**
	 * view반환이 void인 경우 requestmapping 값 기준으로 페이지 선택. (requestmapping의 value를 반환 했다고 생각하면 됨)
	 * @param model
	 */
	@RequestMapping(value="/v02", method=RequestMethod.GET)
	public void view02(Model model) {
		model.addAttribute("requestMethodName", "view02()");
//		return "viewEx/v01";
	}
	
	@RequestMapping(value="/v03", method=RequestMethod.GET)
	public List<Customer> view03(Model model) {

		List<Customer> list = new ArrayList<Customer>();
		list.add((Customer)this.context.getBean("custommer"));
		list.add((Customer)this.context.getBean("custommer"));
		list.add((Customer)this.context.getBean("custommer"));
		list.add((Customer)this.context.getBean("custommer"));
		list.add((Customer)this.context.getBean("custommer"));
		
		model.addAttribute("requestMethodName", "view03()");
		model.addAttribute("custommerList", list);
		
		return list;
	}
}
