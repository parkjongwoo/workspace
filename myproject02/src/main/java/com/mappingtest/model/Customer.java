package com.mappingtest.model;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	String id;
	String name;
	
	public Customer() {
		
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
	
	
	
}
