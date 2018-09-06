package com.mybatis.bookshop.shop.condition;

public class BookCondition {
	private String bookName;
	private String publisher;
	private Integer priceMin;
	private Integer priceMax;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}
	public Integer getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(Integer priceMax) {
		this.priceMax = priceMax;
	}
	@Override
	public String toString() {
		return "BookCondition [bookName=" + bookName + ", publisher=" + publisher + ", priceMin=" + priceMin
				+ ", priceMax=" + priceMax + "]";
	}
	
	
}
