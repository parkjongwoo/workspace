package com.mybatis.bookshop.repository;

import java.util.List;

import com.mybatis.bookshop.condition.BookCondition;
import com.mybatis.bookshop.model.Book;
import com.mybatis.bookshop.model.Customer;
import com.mybatis.bookshop.model.Order;
import com.mybatis.bookshop.model.OrderItem;

public interface BookShopRepository {

	Customer findByCustomerId(int customerid);	
	Book findByBookId(int bookid);
	Customer findCustomerByLoginInfo(Customer formInfo);
	
	OrderItem findByOrderItemId(int orderItemid);
	
	Order findByOrderId(int orderid);
	
	int insertBookInfo(Book book);
	List<Book> findByBookCondition(BookCondition bookCondition);
	
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
