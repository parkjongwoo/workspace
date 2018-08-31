package com.customer.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		return c;
	}

}
