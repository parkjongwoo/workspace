package com.customer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.customer.dao.BaseDao;
import com.customer.model.Customer;
import com.customer.sql.CustomerSQL;

@Repository("JDBCCustomerRepository")
public class JDBCCustomerRepository extends BaseDao implements CustomerRepository {
	
	
	@Override
	public List<Customer> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> result = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(CustomerSQL.SQL_CUSTOMER_SELECT_ALL);
			rs = ps.executeQuery();
			result = new ArrayList<Customer>();
			
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerid(rs.getInt(1));
				c.setId(rs.getString(2));
				c.setName(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setPostcode(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setAddress2(rs.getString(7));
				c.setPhone(rs.getString(8));
				c.setEmail(rs.getString(9));
				result.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result;
	}

	@Override
	public Customer selectByCustomerId(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer result = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(CustomerSQL.SQL_CUSTOMER_SELECT_BY_CUSTOMERID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			result = new Customer();			
			while(rs.next()) {				
				result.setCustomerid(rs.getInt(1));
				result.setId(rs.getString(2));
				result.setName(rs.getString(3));
				result.setPassword(rs.getString(4));
				result.setPostcode(rs.getString(5));
				result.setAddress(rs.getString(6));
				result.setAddress2(rs.getString(7));
				result.setPhone(rs.getString(8));
				result.setEmail(rs.getString(9));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		System.out.println("id:"+id+" result:"+result);
		return result;
	}

	@Override
	public Customer selectById(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer result = null;
		System.out.println("id:"+id);
		try {
			con = getConnection();
			ps = con.prepareStatement(CustomerSQL.SQL_CUSTOMER_SELECT_BY_ID);
			ps.setString(1, id);
			rs = ps.executeQuery();
			result = new Customer();
			
			while(rs.next()) {				
				result.setCustomerid(rs.getInt(1));
				result.setId(rs.getString(2));
				result.setName(rs.getString(3));
				result.setPassword(rs.getString(4));
				result.setPostcode(rs.getString(5));
				result.setAddress(rs.getString(6));
				result.setAddress2(rs.getString(7));
				result.setPhone(rs.getString(8));
				result.setEmail(rs.getString(9));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result;
	}

	@Override
	public int selectCntById(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(CustomerSQL.SQL_CUSTOMER_COUNT_BY_ID);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {				
				result = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result;
	}

	@Override
	public List<Customer> selectByName(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> result = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(CustomerSQL.SQL_CUSTOMER_SELECT_BY_NAME);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			result = new ArrayList<Customer>();
			
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerid(rs.getInt(1));
				c.setId(rs.getString(2));
				c.setName(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setPostcode(rs.getString(5));
				c.setAddress(rs.getString(6));
				c.setAddress2(rs.getString(7));
				c.setPhone(rs.getString(8));
				c.setEmail(rs.getString(9));
				result.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result;
	}

	@Override
	public int insert(Customer customer) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(CustomerSQL.SQL_CUSTOMER_INSERT);
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

	@Override
	public int update(Customer customer) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(CustomerSQL.SQL_CUSTOMER_UPDATE_BY_ID);
			ps.setString(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getPassword());
			ps.setString(4, customer.getPostcode());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getAddress2());
			ps.setString(7, customer.getPhone());
			ps.setString(8, customer.getEmail());
			ps.setInt(9, customer.getCustomerid());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}		
		return result;
	}

	@Override
	public int delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(CustomerSQL.SQL_CUSTOMER_DELETE_BY_ID);
			ps.setInt(1, id);			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}		
		return result;
	}

}
