package com.naverapi.search.vo;

public class ChildVo {
	private String title;
	private int no;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "ChildVo [title=" + title + ", no=" + no + "]";
	}
	
}
