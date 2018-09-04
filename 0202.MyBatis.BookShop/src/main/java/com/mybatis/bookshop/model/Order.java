package com.mybatis.bookshop.model;

import java.sql.Date;
import java.util.List;

public class Order {
	private int orderid;
	private Date orderDate;
	private int amount;
	private String sendYN;
	private int payOption;
	/**
	 * 주문에 관련된 테이블 Customer의 레코드 
	 */
	private Customer customer;
	/**
	 * 주문에 관련된 테이블 OrderItem의 레코드 목록
	 */
	private List<OrderItem> orderItemList;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSendYN() {
		return sendYN;
	}
	public void setSendYN(String sendYN) {
		this.sendYN = sendYN;
	}
	public int getPayOption() {
		return payOption;
	}
	public void setPayOption(int payOption) {
		this.payOption = payOption;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderDate=" + orderDate + ", amount=" + amount + ", sendYN=" + sendYN
				+ ", payOption=" + payOption + ", customer=" + customer + ", orderItemList=" + orderItemList + "]";
	}		
}
