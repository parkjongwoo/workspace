package com.mybatis.bookshop.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;


public class Customer {
	int customerid;
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$",message="아이디는 영문자로 시작,5~12자 이내")
	private String id;
	@Size(min=2,max=10,message="이름은 2자이상 20자 이내 작성")
	private String name; 
	@Size(min=5,max=12,message="패스워드는 5~12자 이내 작성")
	private String password;
	//@Size(min=5,max=5,message="우편번호는 5자리 코드")
	private String postcode;
	//@Size(min=4,max=10,message="주소는 필수입력 항목")
	private String address; 
	private String address2; 
	private String phone; 
	@Email(regexp="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$",
			message="이메일형식에 맞지 않음")
	private String email;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", id=" + id + ", name=" + name + ", password=" + password
				+ ", postcode=" + postcode + ", address=" + address + ", address2=" + address2 + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	
	
}
