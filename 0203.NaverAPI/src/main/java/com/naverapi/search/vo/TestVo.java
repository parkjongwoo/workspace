package com.naverapi.search.vo;

import java.util.List;

public class TestVo {
	private String title;
	private int no;
	private ChildVo child;
	private List<ChildVo> childList;
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
	public ChildVo getChild() {
		return child;
	}
	public void setChild(ChildVo child) {
		this.child = child;
	}
	public List<ChildVo> getChildList() {
		return childList;
	}
	public void setChildList(List<ChildVo> childList) {
		this.childList = childList;
	}
	@Override
	public String toString() {
		return "TestVo [title=" + title + ", no=" + no + ", child=" + child + ", childList=" + childList + "]";
	}	
}
