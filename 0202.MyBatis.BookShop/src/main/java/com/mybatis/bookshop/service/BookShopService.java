package com.mybatis.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mybatis.bookshop.model.OrderItem;
import com.mybatis.bookshop.repository.BookShopRepository;

@Service
public class BookShopService {
	
	@Autowired
	@Qualifier("MyBatisBookShopRepository")
	private BookShopRepository bookShopRepository;
	
	
	public OrderItem getOrderItemById(int orderItemid) {
		OrderItem item = bookShopRepository.findByOrderItemId(orderItemid);
		return item;
	}
	
//	public String saveCustomer(Customer customer) {
//		int count = customerRepository.insert(customer);
//		
//		String result = "가입실패";
//		
//		if (count > 0) {
//			result = "가입성공";
//		} 
//		
//		return result;
//	}	
//	
//	public Customer getCustomerByCustomerId(int customerid) {
//		Customer c = customerRepository.selectByCustomerId(customerid);
//		return c;
//	}
//	
//	public Customer getCustomerById(String id) {
//		Customer c = customerRepository.selectById(id);
//		return c;
//	}
//
//	public List<Customer> getCustomers() {
//		List<Customer> list = customerRepository.selectAll();
//		return list;
//	}
//
//	public List<Customer> getCustomersByName(String name) {
//		List<Customer> list = customerRepository.selectByName(name);
//		return list;
//	}
//
//
//
//	public String updateCustomer(Customer customer) {
//		String msg = null;
//		int result = customerRepository.update(customer);
//		
//		msg = result>0?"수정되었습니다.":"수정실패하였습니다.";
//		//수정실패 또는 수정성공 String 리턴
//		return msg;
//	}
//
//	public String deleteCustomer(int id) {		
//		String msg = null;
//		int result = customerRepository.delete(id);
//		
//		msg = result>0?"삭제되었습니다.":"삭제실패하였습니다.";
//		//수정실패 또는 수정성공 String 리턴
//		return msg;
//	}
//	
//	public boolean getIdCheckResult(String id){
//		int result = customerRepository.selectCntById(id);
//		boolean isNewId = result==0;
//		//이미 존재하는 아이디 false
//		//존재하지 않는 아이디 true
//		return isNewId;	
//	}
//	
//	/**
//	 * 페이지 갯수 반환.
//	 * 총 row / 페이지당 row   값을 올림. > 페이지당 row가 남은 페이지가 있으므로.
//	 * @return
//	 */
//	public int getPageCount() {
//		int totalRow = customerRepository.findCount();		
//		return totalRow/Page.ROWS_PER_PAGE + (totalRow%Page.ROWS_PER_PAGE==0?0:1);//올림처리. double 변환후 올림하는 것보다 자원소모 적음.
//	}
//	
//	public List<Customer> getCustomersByPageNo(int page) {	
//		RowBounds rowBounds = new RowBounds(Page.ROWS_PER_PAGE*(page-1), Page.ROWS_PER_PAGE);
//		List<Customer> list = customerRepository.findByPage(rowBounds);
//		return list;
//	}
//	
//	public int getFirstPageNum(int page, int pageCount) {
////		int totalPageGroup = pageCount/Page.PAGES_PER_PAGEGROUP + (pageCount%Page.PAGES_PER_PAGEGROUP==0?0:1);
//		int currentPageGroup = page/Page.PAGES_PER_PAGEGROUP + (page%Page.PAGES_PER_PAGEGROUP==0?0:1);
//		int firstPageNum = (currentPageGroup-1)*Page.PAGES_PER_PAGEGROUP+1;
//		if(firstPageNum<1) {
//			firstPageNum = 1;
//		}
//		return firstPageNum;
//	}
//	
//	public int getLastPageNum(int page, int pageCount) {
////		int totalPageGroup = pageCount/Page.PAGES_PER_PAGEGROUP + (pageCount%Page.PAGES_PER_PAGEGROUP==0?0:1);
//		int currentPageGroup = page/Page.PAGES_PER_PAGEGROUP + (page%Page.PAGES_PER_PAGEGROUP==0?0:1);
//		int lastPageNum = currentPageGroup*Page.PAGES_PER_PAGEGROUP;
//		if(lastPageNum > pageCount) {
//			lastPageNum = pageCount;
//		}
//		return lastPageNum;
//	}
}
