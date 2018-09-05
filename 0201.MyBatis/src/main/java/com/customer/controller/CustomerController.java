package com.customer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.model.Customer;
import com.customer.search.condition.CustomerCondition;
import com.customer.service.CustomerService;

/**
 * mybatis를 이용한 Repository, DB간 간략화 실습
 * 
 * @author goott3-4
 *
 */
@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customer_save", method = RequestMethod.GET)
	public String getForm(Customer customer) {
		return "insert";
	}
	
	@RequestMapping(value = "/customer_save", method = RequestMethod.POST)
	public String getFormPost(Customer customer) {
		return "insert";
	}
	
	@RequestMapping(value = "/insert_customer", method = RequestMethod.POST)
	public String add(
			@Valid Customer customer,			
			BindingResult bindingResult,
			Model model) {
		System.out.println(customer.toString());
		
		if(bindingResult.hasErrors()) {
			System.out.println("error");
//			model.addAttribute("customer", customer);
			return "insert";
		}
		
		System.out.println("no error");
		String result = customerService.saveCustomer(customer);

		model.addAttribute("message", result);
		
		return "redirect:/page";
	}
	
//	@ModelAttribute("customers")//생략가능, collection 인 경우도 "generic형+List"등의 형식으로 자동 저장.여기서는 "customerList"
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Customer> list() {
		List<Customer> list = customerService.getCustomers();
		
		return list;
	}
	
//	@ModelAttribute("customer")//생략가능, collection 인 경우도 "generic형+List"등의 형식으로 자동 저장
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public Customer detail(@RequestParam int customerid) {
		Customer c = customerService.getCustomerByCustomerId(customerid);		
		return c;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCustomer(Customer customer, Model model) {
		System.out.println("update:"+customer);
		String msg = customerService.updateCustomer(customer);
		model.addAttribute("msg", msg);
		return "redirect:/page";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteCustomer(@RequestParam int customerid, Model model) {
		String msg = customerService.deleteCustomer(customerid);
		model.addAttribute("msg", msg);		
		return "redirect:/page";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(CustomerCondition customerCondition, Model model) {
		System.out.println("customerCondition:"+customerCondition);
		List<Customer> list = null;
		if("이름".equals(customerCondition.getType())) {
			list = customerService.getCustomersByName(customerCondition.getSearchWord());
		}else if("아이디".equals(customerCondition.getType())) {
			list = new ArrayList<Customer>();
			list.add(customerService.getCustomerById(customerCondition.getSearchWord()));
		}else {
			list = customerService.getCustomers();
		}
		
		model.addAttribute("seachType", customerCondition.getType());
		model.addAttribute("searchWord", customerCondition.getSearchWord());
		model.addAttribute("customers", list);
		return "list";
	}
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public String idCheck(@RequestParam String id, Model model) {
		
		boolean result = customerService.getIdCheckResult(id);
		model.addAttribute("isNewId", result);
		return "idcheck";
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ModelAttribute("customers")
	public List<Customer> page(@RequestParam(defaultValue="1") int selectPage,Model model){
		List<Customer> customers = customerService.getCustomersByPageNo(selectPage);
		int pageCount = customerService.getPageCount();
		int firstPageNum = customerService.getFirstPageNum(selectPage ,pageCount);
		int lastPageNum = customerService.getLastPageNum(selectPage ,pageCount);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("selectPage", selectPage);
		model.addAttribute("firstPageNum", firstPageNum);
		model.addAttribute("lastPageNum", lastPageNum);
		
		return customers;
	}
}