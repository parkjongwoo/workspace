package com.homework.guestbook.mapper;

import java.util.List;

import com.homework.guestbook.model.GuestBookItem;

public interface GuestBookItemMapper {
	GuestBookItem selectById(int num);
	List<GuestBookItem> selectAll();
	
	boolean insert(GuestBookItem item);
	boolean update(GuestBookItem item);
	boolean delete(int num);
}
