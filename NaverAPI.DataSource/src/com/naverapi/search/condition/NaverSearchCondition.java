package com.naverapi.search.condition;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class NaverSearchCondition {
	private String query;
	private int display;
	private int start;
	private String sort;
	private String category;
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "NaverSearchCondition [query=" + query + ", display=" + display + ", start=" + start + ", sort=" + sort
				+ ", category=" + category + "]";
	}
	public String buidQueryString() {
		StringBuffer sb = new StringBuffer();
		sb.append("?");
		
		if(category != null && !category.trim().equals("")) {
			sb.append(category+"=").append(getEncodedString(query)).append('&');			
		}
		if(query != null && !query.trim().equals("")) {
			sb.append("query=").append(getEncodedString(query)).append('&');
		}
		if(display > 0) {
			sb.append("display=").append(display).append('&');			
		}
		if(start > 0) {
			sb.append("start=").append(start).append('&');			
		}
		if(sort != null && !sort.trim().equals("")) {
			sb.append("sort=").append(getEncodedString(sort));			
		}
		
		
		return sb.toString();
	}
	
	public String getEncodedString(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return s;
		}
	}
}
