package com.homework.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.homework.guestbook.model.GuestBookItem;
import com.homework.guestbook.repository.GuestBookRepository;

@Service
public class GuestBookService {
	
	@Autowired
//	@Qualifier("JDBCGuestBookRepository")
//	@Qualifier("JDBCTemplateGuestBookRepository")
	@Qualifier("MyBatisGuestBookRepository")
	private GuestBookRepository repository;
	
	public GuestBookItem selectById(int num) {
		return repository.selectById(num);
	}
	public List<GuestBookItem> selectAll(){
		return repository.selectAll();
	}
	
	public String insert(GuestBookItem item) {
		boolean result = repository.insert(item);
		return result?"추가되었습니다.":"추가 실패하였습니다.";
	}
	public String update(GuestBookItem item) {
		boolean result = repository.update(item);
		return 	result?"변경되었습니다.":"변경 실패하였습니다.";
	}
	public String delete(int num) {
		boolean result =  repository.delete(num);
		return result?"삭제되었습니다.":"삭제 실패하였습니다.";
	}
	
}
