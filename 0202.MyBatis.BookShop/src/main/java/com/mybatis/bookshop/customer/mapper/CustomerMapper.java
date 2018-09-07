package com.mybatis.bookshop.customer.mapper;

import java.util.List;

import com.mybatis.bookshop.customer.condition.CustomerCondition;
import com.mybatis.bookshop.customer.model.Customer;

public interface CustomerMapper {
	Customer findByCustomerId(int customerid);

	Customer findCustomerByLoginInfo(Customer formInfo);

	// 동적 sql
	List<Customer> findCustomer(CustomerCondition customerCondition);
	
	int insertCustomer(Customer customer);
}
