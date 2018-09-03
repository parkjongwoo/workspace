package com.homework.guestbook.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.homework.guestbook.model.GuestBookItem;

@Component
public class GuestBookRowMapper implements RowMapper<GuestBookItem> {
	
	public GuestBookRowMapper() {}
	@Override
	public GuestBookItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		GuestBookItem item = new GuestBookItem();
		item.setNo(rs.getInt(1));
		item.setNum(rs.getInt(2));
		item.setName(rs.getString(3));
		item.setSubject(rs.getString(4));
		item.setContent(rs.getString(5));
		item.setWritedate(rs.getDate(6));
		return item;
	}

}
