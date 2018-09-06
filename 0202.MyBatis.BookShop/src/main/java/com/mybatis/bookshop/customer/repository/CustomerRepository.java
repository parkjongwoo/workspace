package com.mybatis.bookshop.customer.repository;

import com.mybatis.bookshop.customer.model.Customer;

public interface CustomerRepository {
	
	Customer findByCustomerId(int customerid);	
	Customer findCustomerByLoginInfo(Customer formInfo);
	
//	int selectCntById(String id);
//	List<Customer> selectByName(String name);
//	
//	int insert(Customer customer);		
//	int update(Customer customer);
//	int delete(int id);
//	
//	//페이징
//	//1.데이터 총 개수
//	int findCount();
//	
//	//2.rowbounds
//	List<Customer> findByPage(RowBounds rowBounds);
}
