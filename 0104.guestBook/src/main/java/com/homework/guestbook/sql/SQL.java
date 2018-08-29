package com.homework.guestbook.sql;

public class SQL {
	public static final String GUESTBOOK_SELECT_ALL =
			"SELECT * FROM " + 
			"(SELECT ROWNUM RNUM,G.* FROM (SELECT * FROM GUESTBOOK ORDER BY WRITEDATE) G) " + 
			"ORDER BY RNUM DESC";
	public static final String GUESTBOOK_SELECT_BY_ID =
			"SELECT * FROM GUESTBOOK WHERE NUM=?";
	public static final String GUESTBOOK_INSERT =
			"INSERT INTO GUESTBOOK VALUES( " + 
			"SEQ_GUESTBOOK_NUM.NEXTVAL, " + 
			"?, " + 
			"?, " + 
			"?, " + 
			"SYSDATE)";
	public static final String GUESTBOOK_UPDATE =
			"UPDATE GUESTBOOK SET " + 
			"NAME=?, " + 
			"SUBJECT=?, " + 
			"CONTENT=?, " + 
			"WRITEDATE=SYSDATE " + 
			"WHERE NUM=?";
	public static final String GUESTBOOK_DELETE_BY_ID =
			"DELETE FROM GUESTBOOK WHERE NUM=?";
}
