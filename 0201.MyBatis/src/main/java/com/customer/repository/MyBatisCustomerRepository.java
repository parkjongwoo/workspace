package com.customer.repository;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.mapper.CustomerMapper;
import com.customer.model.Customer;

@Repository("MyBatisCustomerRepository")
public class MyBatisCustomerRepository implements CustomerRepository {
	
	/**
	 * interface, xml 분리된 Mapper
	 */
	@Autowired
	private CustomerMapper mapper;
	
	/**
	 * interface, xml 통합된 Mapper
	 */
//	@Autowired
//	private AnnotationCustomerMapper mapper;

	@Override
	public List<Customer> selectAll() {
		
		return mapper.findAll();
	}

	@Override
	public Customer selectByCustomerId(int id) {
		
		return mapper.findByCustomerId(id);
	}

	@Override
	public Customer selectById(String id) {
		
		return mapper.findById(id);
	}

	@Override
	public int selectCntById(String id) {
		
		return mapper.findCntById(id);
	}

	@Override
	public List<Customer> selectByName(String name) {
		
		return mapper.findbyName(name);
	}

	@Override
	public int insert(Customer customer) {
		
		return mapper.save(customer);
	}

	@Override
	public int update(Customer customer) {
		
		return mapper.modify(customer);
	}

	@Override
	public int delete(int id) {
		
		return mapper.remove(id);
	}
	
	@Override
	public int findCount() {
		return mapper.findCount();
	}
	
	@Override
	public List<Customer> findByPage(RowBounds rowBounds){
		return mapper.findByPage(rowBounds);
	}
}
