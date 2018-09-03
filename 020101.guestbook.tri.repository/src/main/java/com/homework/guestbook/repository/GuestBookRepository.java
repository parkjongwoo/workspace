package com.homework.guestbook.repository;

import java.util.List;

import com.homework.guestbook.model.GuestBookItem;

public interface GuestBookRepository {
	GuestBookItem selectById(int num);
	List<GuestBookItem> selectAll();
	
	boolean insert(GuestBookItem item);
	boolean update(GuestBookItem item);
	boolean delete(int num);
}
