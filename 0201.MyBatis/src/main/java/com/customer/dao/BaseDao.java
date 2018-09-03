package com.customer.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


public class BaseDao implements Dao {
	
	@Autowired
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Connection getConnection() {		
		Connection con = null;		
		try {			
			con = dataSource.getConnection();
			System.out.println("디비 연결 성공"+ con.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeDBObjects(ResultSet resultSet, Statement statement, Connection connection) {
		if(resultSet != null) {
			try {
				resultSet.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
