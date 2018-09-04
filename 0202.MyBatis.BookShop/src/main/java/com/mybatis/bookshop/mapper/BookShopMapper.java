package com.mybatis.bookshop.mapper;

import com.mybatis.bookshop.model.Book;
import com.mybatis.bookshop.model.Customer;
import com.mybatis.bookshop.model.OrderItem;


public interface BookShopMapper {
	
	
	Customer findByCustomerId(int customerid);	
	Book findByBookId(int bookid);
	OrderItem findByOrderItemId(int orderItemid);	
}
