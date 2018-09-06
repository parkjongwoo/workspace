package com.mybatis.bookshop.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mybatis.bookshop.customer.model.Customer;
import com.mybatis.bookshop.shop.condition.BookCondition;
import com.mybatis.bookshop.shop.condition.OrderCondition;
import com.mybatis.bookshop.shop.condition.OrderItemCondition;
import com.mybatis.bookshop.shop.model.Book;
import com.mybatis.bookshop.shop.model.Order;
import com.mybatis.bookshop.shop.model.OrderItem;
import com.mybatis.bookshop.shop.service.ShopService;

/**
 * mybatis를 이용한 Repository, DB간 간략화 실습
 * 
 * @author goott3-4
 *
 */
@Controller
@SessionAttributes("loginInfo")
public class ShopController {
	@Autowired
	private ShopService bookShopService;
	
	@RequestMapping(value="/searchOrderItem", method=RequestMethod.GET)
	public String searchOrderItem() {
		return "searchOrderItem";
	}
	
	@RequestMapping(value="/searchOrderItem", method=RequestMethod.POST)
	public String getOrderItemPost(OrderItemCondition orderItemCondition, Model model) {
		OrderItem item = bookShopService.getOrderItemById(orderItemCondition.getOrderitemid());
		model.addAttribute("orderItem", item);
		return "searchOrderItem";
	}
	
	@RequestMapping(value="/searchOrder", method=RequestMethod.GET)
	public String searchOrder() {
		return "searchOrder";
	}
	
	@RequestMapping(value="/searchOrder", method=RequestMethod.POST)
	public String getOrder(OrderCondition orderCondition, Model model) {
		Order order = bookShopService.getOrderById(orderCondition.getOrderid());
		model.addAttribute("order", order);
		return "searchOrder";
	}
	
	@RequestMapping(value="/bookInsertForm", method=RequestMethod.GET)
	public String bookInsertForm() {
		return "bookInsertForm";
	}
	
	@RequestMapping(value="/insertBook", method=RequestMethod.POST)
	public String getOrder(Book book, Model model) {
		String msg = bookShopService.insertBookInfo(book);
		model.addAttribute("msg", msg);
		model.addAttribute("book", book);
		return "bookInsertForm";
	}
	
	@RequestMapping(value="/searchBook", method=RequestMethod.GET)
	public String searchBook(@ModelAttribute("bookCondition") BookCondition bookCondition, Model model) {
		System.out.println(bookCondition);
		List<Book> bookList = bookShopService.getBookByCondition(bookCondition);
		model.addAttribute("bookList", bookList);
		model.addAttribute("bookCondition", bookCondition);
		return "searchBook";
	}
	
	@RequestMapping(value="/insertOrder", method=RequestMethod.POST)
	public String insertOrder( @ModelAttribute("loginInfo") Customer loginInfo, @ModelAttribute("order") Order order, Model model) {
		
		List<OrderItem> orderItemList = order.getOrderItemList();
		int size = orderItemList.size();
		int amount = 0;
		for(int i=size-1;i>=0;i--) {
			OrderItem item = orderItemList.get(i);
			if(item.getQuantity()<=0) {
				orderItemList.remove(i);
			}else {
				amount += (item.getQuantity() * item.getBook().getPrice());
			}
		}
		order.setCustomer(loginInfo);
		order.setAmount(amount);
		order.setSendYN("N");
		order.setPayOption(1);
		System.out.println(order);
		String message = bookShopService.insertOrder(order);
		model.addAttribute("message", message);
		return "checkoutResult";
	}
//	@RequestMapping(value = "/customer_save", method = RequestMethod.GET)
//	public String getForm(Customer customer) {
//		return "insert";
//	}
//	
//	@RequestMapping(value = "/customer_save", method = RequestMethod.POST)
//	public String getFormPost(Customer customer) {
//		return "insert";
//	}
//	
//	@RequestMapping(value = "/insert_customer", method = RequestMethod.POST)
//	public String add(
//			@Valid Customer customer,			
//			BindingResult bindingResult,
//			Model model) {
//		System.out.println(customer.toString());
//		
//		if(bindingResult.hasErrors()) {
//			System.out.println("error");
////			model.addAttribute("customer", customer);
//			return "insert";
//		}
//		
//		System.out.println("no error");
//		String result = bookShopService.saveCustomer(customer);
//
//		model.addAttribute("message", result);
//		
//		return "redirect:/page";
//	}
//	
//	@ModelAttribute("customers")
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public List<Customer> list() {
//		List<Customer> list = bookShopService.getCustomers();
//		
//		return list;
//	}
//	
//	@ModelAttribute("customer")
//	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	public Customer detail(@RequestParam int customerid) {	
//		
//		Customer c = bookShopService.getCustomerByCustomerId(customerid);		
//		return c;
//	}
//
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String updateCustomer(Customer customer, Model model) {
//		System.out.println("update:"+customer);
//		String msg = bookShopService.updateCustomer(customer);
//		model.addAttribute("msg", msg);
//		return "redirect:/page";
//	}
//
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public String deleteCustomer(@RequestParam int customerid, Model model) {
//		String msg = bookShopService.deleteCustomer(customerid);
//		model.addAttribute("msg", msg);		
//		return "redirect:/page";
//	}
//
//	@RequestMapping(value = "/search", method = RequestMethod.GET)
//	public String search(OrderItemCondition orderItemCondition, Model model) {
//		System.out.println("customerCondition:"+customerCondition);
//		List<Customer> list = null;
//		if("이름".equals(customerCondition.getType())) {
//			list = bookShopService.getCustomersByName(customerCondition.getSearchWord());
//		}else if("아이디".equals(customerCondition.getType())) {
//			list = new ArrayList<Customer>();
//			list.add(bookShopService.getCustomerById(customerCondition.getSearchWord()));
//		}else {
//			list = bookShopService.getCustomers();
//		}
//		
//		model.addAttribute("seachType", customerCondition.getType());
//		model.addAttribute("searchWord", customerCondition.getSearchWord());
//		model.addAttribute("customers", list);
//		return "list";
//	}
//	
//	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
//	public String idCheck(@RequestParam String id, Model model) {
//		
//		boolean result = bookShopService.getIdCheckResult(id);
//		model.addAttribute("isNewId", result);
//		return "idcheck";
//	}
//	
//	@RequestMapping(value = "/page", method = RequestMethod.GET)
//	@ModelAttribute("customers")
//	public List<Customer> page(@RequestParam(defaultValue="1") int selectPage,Model model){
//		List<Customer> customers = bookShopService.getCustomersByPageNo(selectPage);
//		int pageCount = bookShopService.getPageCount();
//		int firstPageNum = bookShopService.getFirstPageNum(selectPage ,pageCount);
//		int lastPageNum = bookShopService.getLastPageNum(selectPage ,pageCount);
//		model.addAttribute("pageCount", pageCount);
//		model.addAttribute("selectPage", selectPage);
//		model.addAttribute("firstPageNum", firstPageNum);
//		model.addAttribute("lastPageNum", lastPageNum);
//		
//		return customers;
//	}
}