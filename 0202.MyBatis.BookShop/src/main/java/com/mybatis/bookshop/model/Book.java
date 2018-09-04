package com.mybatis.bookshop.model;

public class Book {
	private int bookid;
	private String bookName;
	private String publisher;
	private int price;
	private String description;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookName=" + bookName + ", publisher=" + publisher + ", price=" + price
				+ ", description=" + description + "]";
	}
	
	
}
