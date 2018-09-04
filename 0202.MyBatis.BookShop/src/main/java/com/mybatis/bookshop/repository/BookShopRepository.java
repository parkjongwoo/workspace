package com.mybatis.bookshop.repository;

import com.mybatis.bookshop.model.Book;
import com.mybatis.bookshop.model.Customer;
import com.mybatis.bookshop.model.OrderItem;

public interface BookShopRepository {

	Customer findByCustomerId(int customerid);	
	Book findByBookId(int bookid);
	OrderItem findByOrderItemId(int orderItemid);
	
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
