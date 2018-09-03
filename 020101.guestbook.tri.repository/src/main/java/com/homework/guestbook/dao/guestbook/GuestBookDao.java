package com.homework.guestbook.dao.guestbook;

import java.util.List;

import com.homework.guestbook.model.GuestBookItem;

public interface GuestBookDao {
	GuestBookItem selectById(int num);
	List<GuestBookItem> selectAll();
	
	boolean insert(GuestBookItem item);
	boolean update(GuestBookItem item);
	boolean delete(int num);
	
	
}
