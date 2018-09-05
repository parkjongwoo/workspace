package com.mybatis.bookshop.mapper;

import java.util.List;

import com.mybatis.bookshop.condition.BookCondition;
import com.mybatis.bookshop.condition.CustomerCondition;
import com.mybatis.bookshop.model.Book;
import com.mybatis.bookshop.model.Customer;
import com.mybatis.bookshop.model.Order;
import com.mybatis.bookshop.model.OrderItem;


public interface BookShopMapper {	
	
	Customer findByCustomerId(int customerid);	
	
	//1:1관계 테이블 조인
	Book findByBookId(int bookid);
	OrderItem findByOrderItemId(int orderItemid);
	Customer findCustomerByLoginInfo(Customer formInfo);
	List<Book> findByBookCondition(BookCondition bookCondition);
	
	
	//1:N관계 테이블 조인
	Order findByOrderId(int orderid);	
	OrderItem findByOrderIdFromOrderItem(int orderid);
	
	//동적 sql
	List<Customer> findCustomer(CustomerCondition customerCondition);
	
	
	
	int insertBookInfo(Book book);

}
