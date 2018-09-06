package com.mybatis.bookshop.shop.mapper;

import java.util.List;

import com.mybatis.bookshop.customer.condition.CustomerCondition;
import com.mybatis.bookshop.customer.model.Customer;
import com.mybatis.bookshop.shop.condition.BookCondition;
import com.mybatis.bookshop.shop.model.Book;
import com.mybatis.bookshop.shop.model.Order;
import com.mybatis.bookshop.shop.model.OrderItem;


public interface ShopMapper {	
	
	
	
	//1:1관계 테이블 조인
	Book findByBookId(int bookid);
	OrderItem findByOrderItemId(int orderItemid);
	
	List<Book> findByBookCondition(BookCondition bookCondition);
	
	
	//1:N관계 테이블 조인
	Order findByOrderId(int orderid);	
	OrderItem findByOrderIdFromOrderItem(int orderid);
	
		
	int insertBookInfo(Book book);
	
	int insertOrder(Order order);
	
	int getNextvalFromOrderItemSeq();
}
