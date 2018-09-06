package com.mybatis.bookshop.shop.repository;

import java.util.List;

import com.mybatis.bookshop.shop.condition.BookCondition;
import com.mybatis.bookshop.shop.model.Book;
import com.mybatis.bookshop.shop.model.Order;
import com.mybatis.bookshop.shop.model.OrderItem;

public interface ShopRepository {

	
	Book findByBookId(int bookid);	
	OrderItem findByOrderItemId(int orderItemid);	
	Order findByOrderId(int orderid);
	
	
	int insertBookInfo(Book book);
	
	List<Book> findByBookCondition(BookCondition bookCondition);
	
	int getNextvalFromOrderItemSeq();
	int insertOrder(Order order);
}
