package com.mybatis.bookshop.shop.condition;

public class OrderCondition {
	private Integer customerid;
	private Integer orderid;
	private Integer orderDateLimit;
	
	
	public OrderCondition() {
		this.customerid = null;
		this.orderid = null;
		this.orderDateLimit = 6; 
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getOrderDateLimit() {
		return orderDateLimit;
	}

	public void setOrderDateLimit(Integer orderDateLimit) {
		this.orderDateLimit = orderDateLimit;
	}

	@Override
	public String toString() {
		return "OrderCondition [customerid=" + customerid + ", orderid=" + orderid + ", orderDateLimit="
				+ orderDateLimit + "]";
	}

	
}
