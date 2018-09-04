package com.customer.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.customer.model.Customer;

public interface CustomerRepository {

	List<Customer> selectAll();		
	Customer selectByCustomerId(int id);
	Customer selectById(String id);
	
	int selectCntById(String id);
	List<Customer> selectByName(String name);
	
	int insert(Customer customer);		
	int update(Customer customer);
	int delete(int id);
	
	//페이징
	//1.데이터 총 개수
	int findCount();
	
	//2.rowbounds
	List<Customer> findByPage(RowBounds rowBounds);
}
