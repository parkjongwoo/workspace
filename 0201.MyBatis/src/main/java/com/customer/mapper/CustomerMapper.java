package com.customer.mapper;

import java.util.List;

import com.customer.model.Customer;

/**
 * mybatis 이용할때 사용할 Mapper interface 선언
 * @author goott3-4
 *
 */
public interface CustomerMapper {
	List<Customer> findAll();
	Customer findByCustomerId(int customerid);
	Customer findById(String id);	
	List<Customer> findbyName(String name);
	
	int findCntById(String id);
	
	int save(Customer customer);
	int modify(Customer customer);
	int remove(int customerId);
}
