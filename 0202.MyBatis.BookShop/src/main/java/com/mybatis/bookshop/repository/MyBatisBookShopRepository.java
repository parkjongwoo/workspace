package com.mybatis.bookshop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.bookshop.condition.BookCondition;
import com.mybatis.bookshop.mapper.BookShopMapper;
import com.mybatis.bookshop.model.Book;
import com.mybatis.bookshop.model.Customer;
import com.mybatis.bookshop.model.Order;
import com.mybatis.bookshop.model.OrderItem;

@Repository("MyBatisBookShopRepository")
public class MyBatisBookShopRepository implements BookShopRepository {
	
	/**
	 * interface, xml 분리된 Mapper
	 */
	@Autowired
	private BookShopMapper mapper;
	
	/**
	 * interface, xml 통합된 Mapper
	 */
//	@Autowired
//	private AnnotationCustomerMapper mapper;
	
	@Override
	public Customer findByCustomerId(int customerid) {		
		return mapper.findByCustomerId(customerid);
	}

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
	public Customer findCustomerByLoginInfo(Customer formInfo) {
		return mapper.findCustomerByLoginInfo(formInfo);
	}

	@Override
	public int insertBookInfo(Book book) {
		return mapper.insertBookInfo(book);
	}
	
	@Override
	public List<Book> findByBookCondition(BookCondition bookCondition){
		return mapper.findByBookCondition(bookCondition);
	}
	
//	@Override
//	public List<Customer> selectAll() {
//		
//		return mapper.findAll();
//	}
//
//	@Override
//	public Customer selectByCustomerId(int id) {
//		
//		return mapper.findByCustomerId(id);
//	}
//
//	@Override
//	public Customer selectById(String id) {
//		
//		return mapper.findById(id);
//	}
//
//	@Override
//	public int selectCntById(String id) {
//		
//		return mapper.findCntById(id);
//	}
//
//	@Override
//	public List<Customer> selectByName(String name) {
//		
//		return mapper.findbyName(name);
//	}
//
//	@Override
//	public int insert(Customer customer) {
//		
//		return mapper.save(customer);
//	}
//
//	@Override
//	public int update(Customer customer) {
//		
//		return mapper.modify(customer);
//	}
//
//	@Override
//	public int delete(int id) {
//		
//		return mapper.remove(id);
//	}
//	
//	@Override
//	public int findCount() {
//		return mapper.findCount();
//	}
//	
//	@Override
//	public List<Customer> findByPage(RowBounds rowBounds){
//		return mapper.findByPage(rowBounds);
//	}
}
