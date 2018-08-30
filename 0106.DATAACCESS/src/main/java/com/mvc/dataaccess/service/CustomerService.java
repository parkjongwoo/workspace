package com.mvc.dataaccess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dataaccess.model.Customer;
import com.mvc.dataaccess.repository.CustomerRepository;

/**
 * service에서 해야할 일
 * 서버측 유효성검사 등 데이터 조작관련 세밀한 작업.
 * 컨트롤러를 복잡하게 하지 않고 service에서 처리한다.
 * @author goott3-4
 *
 */
@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public String saveCustomer(Customer customer) {
		
		int count = customerRepository.insert(customer);		
		String result = "가입실패";
		
		if(count>0) {
			result = "가입성공";
		}
		
		return result;
	}
}
