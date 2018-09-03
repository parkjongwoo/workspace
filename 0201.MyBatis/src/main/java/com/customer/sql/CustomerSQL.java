package com.customer.sql;

public class CustomerSQL {
	public static final String SQL_CUSTOMER_SELECT_ALL = 
			"SELECT * FROM CUSTOMER ORDER BY CUSTOMERID DESC";
	
	public static final String SQL_CUSTOMER_SELECT_BY_CUSTOMERID = 
			"SELECT * FROM CUSTOMER WHERE CUSTOMERID=?";
	
	public static final String SQL_CUSTOMER_SELECT_BY_ID = 
			"SELECT * FROM CUSTOMER WHERE ID=?";
	
	public static final String SQL_CUSTOMER_COUNT_BY_ID = 
			"SELECT count(*) cnt FROM CUSTOMER WHERE ID=?";
	
	public static final String SQL_CUSTOMER_SELECT_BY_NAME = 
			"SELECT * FROM CUSTOMER WHERE NAME LIKE ?";
	
	public static final String SQL_CUSTOMER_INSERT =
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
	public static final String SQL_CUSTOMER_UPDATE_BY_ID = 
			"UPDATE CUSTOMER SET " + 
			"ID=?, " + 
			"NAME=?, " + 
			"PASSWORD=?, " + 
			"POSTCODE=?, " + 
			"ADDRESS=?, " + 
			"ADDRESS2=?, " + 
			"PHONE=?, " + 
			"EMAIL=? " + 
			"WHERE CUSTOMERID=?";
	public static final String SQL_CUSTOMER_DELETE_BY_ID = 
			"DELETE FROM CUSTOMER WHERE CUSTOMERID=?";
}
