package com.mappingtest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mappingtest.model.Customer;

/**
 * form input으로 crud 실습
 * @author goott3-4
 *
 */
@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	
	List<Customer> list = new ArrayList<Customer>();
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public void showInputView() {
		logger.debug("GET");
		
		
	}
	
	/**
	 * request parameter 값을 Bean으로 전달 받을 때
	 * \@ModelAttribute 요청의 parameter값으로 제공한 Bean의 property를 채워줌. 생략가능
	 * @param c
	 * @return
	 */
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute Customer c) {
		
		
		list.add(c);
		return "redirect:/customer/list";//  "/"경로로 sendredirect
	}
	
	/**
	 * 화면에 값을 보낼 때
	 * \@ModelAttribute 를 method에 지정하면 해당 이름으로 return한 값을 보내겠다는 의미
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ModelAttribute("customers")
	public List<Customer> list() {
		
		
		return list;//  "/"경로로 sendredirect
	}
	
	/**
	 * url queryString을 받는 경우. \@RequestParam 사용
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)	
	@ModelAttribute("customerModel")
	public Customer detail(@RequestParam String id) {
		
		Customer result = null;
		for(Customer c : list) {
			if(c.getId().equals(id)) {
				result = c;
			}
		}
		return result;//  "/"경로로 sendredirect
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)	
	public String update(Customer customer) {
		
		for(Customer c : list) {
			if(c.getId().equals(customer.getId())) {
				c.setName(customer.getName());
			}
		}
		return "redirect:/customer/list";//  "/"경로로 sendredirect
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)	
	public String delete(@RequestParam String id) {
		
		for(Customer c : list) {
			if(c.getId().equals(id)) {
				list.remove(c);
			}
		}
		return "redirect:/customer/list";//  "/"경로로 sendredirect
	}
}
