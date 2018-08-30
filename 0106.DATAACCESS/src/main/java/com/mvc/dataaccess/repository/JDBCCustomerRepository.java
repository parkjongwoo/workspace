package com.mvc.dataaccess.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.mvc.dataaccess.dao.BaseDao;
import com.mvc.dataaccess.model.Customer;

@Repository
public class JDBCCustomerRepository extends BaseDao implements CustomerRepository {
	
	private static final String CUSTOMER_INSERT_SQL =
			"INSERT INTO CUSTOMER VALUES( " + 
			"SEQ_CUSTOMER_ID.NEXTVAL, " + 
			"?, " + 
			"?, " + 
			"?, " + 
			"?, " + 
			"?, " + 
			"?, " + 
			"?, " + 
			"?)";
	@Override
	public int insert(Customer customer) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(CUSTOMER_INSERT_SQL);
			ps.setString(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getPassword());
			ps.setString(4, customer.getPostcode());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getAddress2());
			ps.setString(7, customer.getPhone());
			ps.setString(8, customer.getEmail());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}		
		return result;
	}
	
}
