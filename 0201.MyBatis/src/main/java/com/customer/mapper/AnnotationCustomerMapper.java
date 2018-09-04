package com.customer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.customer.model.Customer;

/**
 * Mapper.java, Mapper.xml을 annotation 이용하여 한 파일로 관리
 * CustomerMapper.java, CustomerMapper.xml 두파일을 이 파일로 합친 것.
 * @author goott3-4
 *
 */
public interface AnnotationCustomerMapper {
	
	@Select("SELECT * FROM CUSTOMER ORDER BY CUSTOMERID DESC")
	List<Customer> findAll();
	
	@Select("SELECT * FROM CUSTOMER WHERE CUSTOMERID=#{customerid}")
	Customer findByCustomerId(int customerid);
	
	@Select("SELECT * FROM CUSTOMER WHERE ID=#{id}")
	Customer findById(String id);	
	
	@Select("SELECT * FROM CUSTOMER WHERE NAME LIKE #{name}")
	List<Customer> findbyName(String name);
	
	@Select("SELECT count(*) cnt FROM CUSTOMER WHERE ID=#{id}")
	int findCntById(String id);
	
	
	@Insert("INSERT INTO CUSTOMER " + 
			"		(CUSTOMERID, ID, NAME, PASSWORD, POSTCODE, ADDRESS, ADDRESS2, PHONE, EMAIL) " + 
			"		VALUES(#{customerid}, #{id}, #{name}, #{password}, #{postcode}, #{address}, #{address2}, #{phone}, #{email})")
	@SelectKey(statement="SELECT SEQ_CUSTOMER_ID.NEXTVAL FROM DUAL",keyProperty="customerid",before=true,resultType=Integer.class)
	int save(Customer customer);
	
	@Update("UPDATE CUSTOMER SET " + 
			"		ID=#{id}, NAME=#{name}, PASSWORD=#{password}, POSTCODE=#{postcode}, " + 
			"		ADDRESS=#{address}, ADDRESS2=#{address2}, PHONE=#{phone}, EMAIL=#{email} WHERE CUSTOMERID=#{customerid}")
	int modify(Customer customer);
	
	@Delete("DELETE FROM CUSTOMER WHERE CUSTOMERID=#{customerid}")
	int remove(int customerId);
	
	//페이징 처리
	//1.데이터 총 개수 구하기
	@Select("SELECT COUNT(*) AS COUNT FROM CUSTOMER ")
	int findCount();
	
	//2.rowbounds
	@Select("SELECT * FROM CUSTOMER ORDER BY CUSTOMERID DESC")
	List<Customer> findByPage(RowBounds rowBounds);
	
}
