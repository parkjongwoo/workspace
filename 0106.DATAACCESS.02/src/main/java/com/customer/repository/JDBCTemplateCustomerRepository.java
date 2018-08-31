package com.customer.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;
import com.customer.model.CustomerRowMapper;
import com.customer.sql.CustomerSQL;

/**
 * repository 작업의 중복된 작업을 제거하여 사용하는 class
 * 순서
 * 1.JdbcTemplate Bean등록 및 datasource 연결 servlet-context.xml 참고
 * 
 * 2.repository에 JdbcTemplate 가져와서 사용. 아래 참조.
 * 
 * 3.RowMapper interface를 구현해두면 resultset 처리코드를 분리할 수 있다.
 * 
 * 
 * %% repository는 DB만 한정이 아니므로 file, memory등 여러 매체를 저장소로 만들기 나름이다.
 * %% service에서 적당히 골라 사용할수 있도록 annotation등을 조정하자.
 * %% file 내보내기 기능 등도 추가해보자.
 * 
 * queryforobject()는 row가 없는 경우 exception 발생 시킴
 * queryforList()는 row가 없으면 빈 list를 반환
 * exception 처리는 비용이 크므로 list로 처리하자		
 * @author goott3-4
 *
 */
@Repository("JDBCTemplateCustomerRepository")
public class JDBCTemplateCustomerRepository implements CustomerRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	@Override
	public List<Customer> selectAll() {
		
		//JdbcTemplate.query(sql, RowMapper<T> RowMapper) 사용
		//RowMapper<T>:: 전달된 sql문을 실행한 결과 ResultSet을 
		//spring 내부에서 각 row별로 순환하여 호출해주는 Mapper  
		return jdbcTemplete.query(CustomerSQL.SQL_CUSTOMER_SELECT_ALL, 
				new CustomerRowMapper());
		
		//queryforobject()는 row가 없는 경우 exception 발생 시킴
		//queryforList()는 row가 없으면 빈 list를 반환
		//exception 처리는 비용이 크므로 list로 처리하자
//		List<Customer> result = jdbcTemplete.queryForList(
//				CustomerSQL.SQL_CUSTOMER_SELECT_ALL,
//				Customer.class);
//		return result;
	}

	@Override
	public Customer selectByCustomerId(int id) {
		Object[] params = new Object[] {id};
		List<Customer> result = jdbcTemplete.query(
				CustomerSQL.SQL_CUSTOMER_SELECT_BY_CUSTOMERID,
				params,
				new CustomerRowMapper());
		return result.size()>0?result.get(0):null;
	}
	
	@Override
	public Customer selectById(String id) {
		Object[] params = new Object[] {id};
		List<Customer> result = jdbcTemplete.query(
				CustomerSQL.SQL_CUSTOMER_SELECT_BY_ID,
				params,
				new CustomerRowMapper());
		return result.size()>0?result.get(0):null;
	}
	/**
	 * queryForInt : 반환형 int, 결과목록의 개수를 반환
	 */
	@Override
	public int selectCntById(String id) {
		return jdbcTemplete.queryForInt(
				CustomerSQL.SQL_CUSTOMER_COUNT_BY_ID,
				id);		
	}

	@Override
	public List<Customer> selectByName(String name) {
		Object[] params = new Object[] {name};
		return jdbcTemplete.query(
				CustomerSQL.SQL_CUSTOMER_SELECT_BY_NAME,
				params,
				new CustomerRowMapper());
	}

	@Override
	public int insert(Customer customer) {
		
		return jdbcTemplete.update(
				CustomerSQL.SQL_CUSTOMER_INSERT, 
				customer.getId(),customer.getName(),customer.getPassword(),
				customer.getPostcode(),customer.getAddress(),customer.getAddress2(),
				customer.getPhone(), customer.getEmail());
	}

	@Override
	public int update(Customer customer) {
		
		return jdbcTemplete.update(
				CustomerSQL.SQL_CUSTOMER_UPDATE_BY_ID, 
				customer.getId(),customer.getName(),customer.getPassword(),
				customer.getPostcode(),customer.getAddress(),customer.getAddress2(),
				customer.getPhone(), customer.getEmail(),customer.getCustomerid());
	}

	@Override
	public int delete(int id) {
		
		return jdbcTemplete.update(
				CustomerSQL.SQL_CUSTOMER_DELETE_BY_ID, id);
	}

}
