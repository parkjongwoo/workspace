package com.homework.guestbook.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.homework.guestbook.model.GuestBookItem;
import com.homework.guestbook.repository.rowmapper.GuestBookRowMapper;
import com.homework.guestbook.sql.SQL;

@Repository("JDBCTemplateGuestBookRepository")
public class JDBCTemplateGuestBookRepository implements GuestBookRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private GuestBookRowMapper mapper;
	@Override
	public GuestBookItem selectById(int num) {
		Object[] params = new Object[] {num};
		List<GuestBookItem> list = jdbcTemplate.query(
				SQL.GUESTBOOK_SELECT_BY_ID, 
				params,
				mapper);
		
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<GuestBookItem> selectAll() {
		List<GuestBookItem> list = jdbcTemplate.query(
				SQL.GUESTBOOK_SELECT_ALL, 
				mapper);		
		return list;
	}

	@Override
	public boolean insert(GuestBookItem item) {		
		int result = jdbcTemplate.update(SQL.GUESTBOOK_INSERT, 
				item.getName(),item.getSubject(),item.getContent());
		return result>0;
	}

	@Override
	public boolean update(GuestBookItem item) {
		int result = jdbcTemplate.update(SQL.GUESTBOOK_UPDATE, 
				item.getName(),item.getSubject(),item.getContent(),item.getNum());
		return result>0;
	}

	@Override
	public boolean delete(int num) {
		int result = jdbcTemplate.update(SQL.GUESTBOOK_DELETE_BY_ID, 
				num);
		return result>0;
	}

}
