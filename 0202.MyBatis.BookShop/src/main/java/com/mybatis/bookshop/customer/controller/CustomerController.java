package com.mybatis.bookshop.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mybatis.bookshop.customer.model.Customer;
import com.mybatis.bookshop.customer.model.Phone;
import com.mybatis.bookshop.customer.model.PhoneList;
import com.mybatis.bookshop.customer.service.CustomerService;

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
	CustomerService customerService;
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm() {
		
		return "loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)	
	public String login(Customer formInfo,Model model) {
		
		Customer loginInfo = customerService.getMatchedLoginInfoCnt(formInfo);		
		if(loginInfo!=null) {
			loginInfo.setPassword(null);
			model.addAttribute("loginInfo", loginInfo);
		}else {
			return "loginForm";
		}
		return "forward:/index.jsp";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/index.jsp";
	}
	
	/**
	 * phone 처리 임시..
	 * 
	 * 화면에서 form의 Collection 형태의 데이터를 보낼때 
	 * spring에서 Collection으로 내부처리 가능하게 하는 방법
	 * 1.각 Item에 해당하는 vo. vo를 타입으로 하는 List를 멤버변수로 가지는 파라메터 처리용 vo. 두 vo를 사용한다.
	 * 2.form 데이터를 수신하는 Controller에서 \@ModelAttribute로 파라메터처리용 vo를 사용한다.(컨트롤러 인수로 사용)
	 * 3.form에서 List의 각 Item에 해당하는 input의 name속성을 "파라메터처리용 vo의 멤버변수명[인덱스번호].아이템vo의 속성명"의 형식으로 지정해준다.
	 * 4.2,3의 매칭이 올바르면 spring내부에서 파라메터 처리용 vo의 List를 form에서 지정한 인덱스번호 순서대로 채워서 Controller파라메터에 보내준다.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/phone",method=RequestMethod.GET)
	public String searchOrderItem(Model model) {
		List<Phone> phoneItems = new ArrayList<Phone>();
		
		phoneItems.add(new Phone("1","갤럭시s"));
		phoneItems.add(new Phone("2","G30"));
		
		model.addAttribute("phoneItems", phoneItems);
		
		return "phone";
		
//		customerService.transactionTest();
//		
//		return "phone";
	}
	@RequestMapping(value="/phone",method=RequestMethod.POST)
	public String getOrderItem(PhoneList phoneList) {
		
		System.out.println(phoneList.getPhones().toString());
		
		return "phone";
	}
	
}
