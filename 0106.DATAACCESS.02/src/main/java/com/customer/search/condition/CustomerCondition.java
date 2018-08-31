package com.customer.search.condition;

import org.springframework.stereotype.Component;

@Component
public class CustomerCondition {
	
	private String searchWord;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	@Override
	public String toString() {
		return "CustomerCondition [searchWord=" + searchWord + ", type=" + type + "]";
	}	
	
	
}
