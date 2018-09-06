package com.mybatis.bookshop.shop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.bookshop.customer.model.Customer;
import com.mybatis.bookshop.shop.condition.BookCondition;
import com.mybatis.bookshop.shop.mapper.ShopMapper;
import com.mybatis.bookshop.shop.model.Book;
import com.mybatis.bookshop.shop.model.Order;
import com.mybatis.bookshop.shop.model.OrderItem;

@Repository("MyBatisBookShopRepository")
public class MyBatisShopRepository implements ShopRepository {
	
	/**
	 * interface, xml 분리된 Mapper
	 */
	@Autowired
	private ShopMapper mapper;
	
	/**
	 * interface, xml 통합된 Mapper
	 */
//	@Autowired
//	private AnnotationCustomerMapper mapper;
	
	

	@Override
	public Book findByBookId(int bookid) {		
		return mapper.findByBookId(bookid);
	}

	@Override
	public OrderItem findByOrderItemId(int orderItemid) {		
		return mapper.findByOrderItemId(orderItemid);
	}

	@Override
	public Order findByOrderId(int orderid) {
		return mapper.findByOrderId(orderid);
	}
	
	

	@Override
	public int insertBookInfo(Book book) {
		return mapper.insertBookInfo(book);
	}
	
	@Override
	public List<Book> findByBookCondition(BookCondition bookCondition){
		return mapper.findByBookCondition(bookCondition);
	}

	@Override
	public int getNextvalFromOrderItemSeq() {
		return mapper.getNextvalFromOrderItemSeq();
	}

	@Override
	public int insertOrder(Order order) {
		return mapper.insertOrder(order);
	}
	
	
}
