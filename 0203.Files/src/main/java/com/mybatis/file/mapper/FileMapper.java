package com.mybatis.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis.file.model.UploadFile;

public interface FileMapper {
	@Insert("INSERT INTO FILEBD VALUES( " + 
			"#{id}, " + 
			"#{writer}, " + 
			"#{title}, " + 
			"#{savedFileName}, " + 
			"#{originalFileName})")
	@SelectKey(statement="SELECT SEQ_FILEBD.NEXTVAL FROM DUAL",keyProperty="id",before=true,resultType=Integer.class)
	int save(UploadFile uploadFile);
	
	
	
	@Select("SELECT * FROM FILEBD ORDER BY ID DESC")
	List<UploadFile> findAll();
	
	@Select("SELECT * FROM FILEBD WHERE ID=#{id}")
	UploadFile findById(int id);
	
	
	
	@Delete("DELETE FROM FILEBD WHERE ID=#{id}")
	int deleteFileById(int id);
}
