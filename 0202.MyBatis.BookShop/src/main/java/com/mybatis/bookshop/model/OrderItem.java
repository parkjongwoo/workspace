package com.mybatis.bookshop.model;

public class OrderItem {
	private int orderItemid;
	private int quantity;
	private Book book;
	public int getOrderItemid() {
		return orderItemid;
	}
	public void setOrderItemid(int orderItemid) {
		this.orderItemid = orderItemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemid=" + orderItemid + ", quantity=" + quantity + ", book=" + book + "]";
	}	
}
