package com.mybatis.bookshop.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.bookshop.shop.condition.BookCondition;
import com.mybatis.bookshop.shop.condition.OrderCondition;
import com.mybatis.bookshop.shop.model.Book;
import com.mybatis.bookshop.shop.model.Order;
import com.mybatis.bookshop.shop.model.OrderItem;
import com.mybatis.bookshop.shop.repository.ShopRepository;

/**
 * \@Transactional annotation
 * class에 지정하면 전체 method에 적용됨
 * propagation: Propagation.SUPPORTS >> 트랜잭션중 select 질의는 허용
 * Propagation.REQUIRED >> 트랜잭션중 다른 질의 불허용
 * @author goott3-4
 *
 */
//@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
@Service
public class ShopService {
	
	@Autowired
	@Qualifier("MyBatisBookShopRepository")
	private ShopRepository bookShopRepository;
	
	
	public OrderItem getOrderItemById(int orderItemid) {
		OrderItem item = bookShopRepository.findByOrderItemId(orderItemid);
		return item;
	}

	public Order getOrderById(int orderid) {
		Order order = bookShopRepository.findByOrderId(orderid);
		return order;
	}
	
	public List<Order> getOrderByCondition(OrderCondition condition) {
		List<Order> orders = bookShopRepository.findByOrderCondition(condition);
		return orders;
	}
	
	public String insertBookInfo(Book book) {
		return bookShopRepository.insertBookInfo(book)>0?"입력되었습니다.":"입력실패했습니다.";
	}
	
	public List<Book> getBookByCondition(BookCondition bookCondition) {		
		return bookShopRepository.findByBookCondition(bookCondition);		 
	}

	//@Transactional(propagation=Propagation.REQUIRED)
	public String insertOrder(Order order) {
		List<OrderItem> orderItemList = order.getOrderItemList();
		for(OrderItem orderItem : orderItemList) {
			orderItem.setOrderItemid(bookShopRepository.getNextvalFromOrderItemSeq());
		}
		return bookShopRepository.insertOrder(order)>0?"주문이 완료되었습니다.":"주문이 실패하였습니다.";
	}
	
}
