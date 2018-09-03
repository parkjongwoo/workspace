package com.homework.guestbook.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homework.guestbook.mapper.GuestBookItemMapper;
import com.homework.guestbook.model.GuestBookItem;

@Repository("MyBatisGuestBookRepository")
public class MyBatisGuestBookRepository implements GuestBookRepository {
	
	@Autowired
	private GuestBookItemMapper mapper;

	@Override
	public GuestBookItem selectById(int num) {
		
		return mapper.selectById(num);
	}

	@Override
	public List<GuestBookItem> selectAll() {
		
		return mapper.selectAll();
	}

	@Override
	public boolean insert(GuestBookItem item) {
		
		return mapper.insert(item);
	}

	@Override
	public boolean update(GuestBookItem item) {
		
		return mapper.update(item);
	}

	@Override
	public boolean delete(int num) {
		
		return mapper.delete(num);
	}

	
	
	
}
