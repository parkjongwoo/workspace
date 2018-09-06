package com.mybatis.bookshop.customer.model;

public class Phone {
	private String id;
	private String name;
	private int quantity;
	
	public Phone () {}
	public Phone(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
	}	
}
