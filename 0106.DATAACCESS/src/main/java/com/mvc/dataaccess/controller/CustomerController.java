package com.mvc.dataaccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.dataaccess.model.Customer;
import com.mvc.dataaccess.service.CustomerService;

/**
 * data source 연결 테스트
 * 순서
 * 
 * ========= 1.JDBC 연결하여 DB준비 ===================
 * 1.dependency 추가 (pom.xml 참조)
 * -jdbc 드라이버 dependency
 * 
 * 2.DataSource Bean def 추가(servlet-context.xml 참조)
 * 
 * ========= 2.Service, Repository 구성 =============
 * 1.data 관련 서비스 제공할 Service class 작성
 * CustomerService.java 참고
 * - service는 repository를 소유하여 데이터 처리를 담당한다.
 * 
 * 2.DB 접속 및 쿼리 실행할 Repository class 작성
 * CustomerRepository, JDBCCustomerRepository 참조
 * - DB관련 쿼리 선택 및 DB 접속 담당
 * 
 * ========= 3.코드 흐름 =====================
 * 화면 > 컨트롤러 > 서비스 > 리파지토리 순으로 처리
 *
 * 
 * @author goott3-4
 *
 */
@RequestMapping(value="/customer/*")
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer_form", method=RequestMethod.GET)
	public String getForm() {
		
		return "customer/insert";
	}
	
	@RequestMapping(value="/customer_save", method=RequestMethod.POST)
	public String add(Customer customer, Model model) {
		
		String result = customerService.saveCustomer(customer);
		model.addAttribute("msg",result);
		return "customer/result";
	}
}
