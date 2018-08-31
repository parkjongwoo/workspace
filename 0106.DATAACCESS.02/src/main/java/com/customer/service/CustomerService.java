package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	@Qualifier("JDBCTemplateCustomerRepository")
	private CustomerRepository customerRepository;

	public String saveCustomer(Customer customer) {
		int count = customerRepository.insert(customer);
		
		String result = "가입실패";
		
		if (count > 0) {
			result = "가입성공";
		} 
		
		return result;
	}	
	
	public Customer getCustomerByCustomerId(int customerid) {
		Customer c = customerRepository.selectByCustomerId(customerid);
		return c;
	}
	
	public Customer getCustomerById(String id) {
		Customer c = customerRepository.selectById(id);
		return c;
	}

	public List<Customer> getCustomers() {
		List<Customer> list = customerRepository.selectAll();
		return list;
	}

	public List<Customer> getCustomersByName(String name) {
		List<Customer> list = customerRepository.selectByName(name);
		return list;
	}



	public String updateCustomer(Customer customer) {
		String msg = null;
		int result = customerRepository.update(customer);
		
		msg = result>0?"수정되었습니다.":"수정실패하였습니다.";
		//수정실패 또는 수정성공 String 리턴
		return msg;
	}

	public String deleteCustomer(int id) {		
		String msg = null;
		int result = customerRepository.delete(id);
		
		msg = result>0?"삭제되었습니다.":"삭제실패하였습니다.";
		//수정실패 또는 수정성공 String 리턴
		return msg;
	}
	
	public boolean getIdCheckResult(String id){
		int result = customerRepository.selectCntById(id);
		boolean isNewId = result==0;
		//이미 존재하는 아이디 false
		//존재하지 않는 아이디 true
		return isNewId;	
	}
}
