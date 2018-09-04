package com.customer.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.customer.model.Customer;

/**
 * mybatis 이용할때 사용할 Mapper interface 선언
 * interface, xml 분리된 선언 방식
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
	
	//페이징 처리
	//1.데이터 총 개수 구하기
	int findCount();
	
	//2.rowbounds
	List<Customer> findByPage(RowBounds rowBounds);
	
}
