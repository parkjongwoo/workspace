package com.homework.guestbook.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.homework.guestbook.dao.BaseDao;
import com.homework.guestbook.model.GuestBookItem;
import com.homework.guestbook.sql.SQL;

@Repository("JDBCGuestBookRepository")
public class JDBCGuestBookRepository extends BaseDao implements GuestBookRepository {

	@Override
	public GuestBookItem selectById(int num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		GuestBookItem item = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.GUESTBOOK_SELECT_BY_ID);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				item = new GuestBookItem();
//				item.setNo(rs.getInt(1));
				item.setNum(rs.getInt(1));
				item.setName(rs.getString(2));
				item.setSubject(rs.getString(3));
				item.setContent(rs.getString(4));
				item.setWritedate(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		
		return item;
	}

	@Override
	public List<GuestBookItem> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<GuestBookItem> list = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.GUESTBOOK_SELECT_ALL);
			rs = ps.executeQuery();
			list = new ArrayList<GuestBookItem>();
			while(rs.next()) {				
				GuestBookItem item = new GuestBookItem();
				item.setNo(rs.getInt(1));
				item.setNum(rs.getInt(2));
				item.setName(rs.getString(3));
				item.setSubject(rs.getString(4));
				item.setContent(rs.getString(5));
				item.setWritedate(rs.getDate(6));
				list.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		
		return list;
	}

	@Override
	public boolean insert(GuestBookItem item) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.GUESTBOOK_INSERT);
			ps.setString(1, item.getName());
			ps.setString(2, item.getSubject());
			ps.setString(3, item.getContent());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		
		return result>0;
	}

	@Override
	public boolean update(GuestBookItem item) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.GUESTBOOK_UPDATE);
			ps.setString(1, item.getName());
			ps.setString(2, item.getSubject());
			ps.setString(3, item.getContent());
			ps.setInt(4, item.getNum());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		
		return result>0;
	}

	@Override
	public boolean delete(int num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.GUESTBOOK_DELETE_BY_ID);
			ps.setInt(1, num);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		
		return result>0;
	}

}
