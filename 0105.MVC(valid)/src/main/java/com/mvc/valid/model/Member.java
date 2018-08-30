package com.mvc.valid.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

/**
 * 유효성 검사 방법
 * @author goott3-4
 *
 */
@Component
public class Member {
	
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$",message="잘못된 id임")
	private String id;
	@Size(min=4,max=10,message="패스워드 형식이 아님")
	private String password;
	@Email(regexp="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z] {2,3}$",message="이메일 형식이 아님")
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
