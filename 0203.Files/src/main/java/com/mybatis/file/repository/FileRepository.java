package com.mybatis.file.repository;

import java.util.List;

import com.mybatis.file.model.UploadFile;

public interface FileRepository {
	int save(UploadFile uploadFile);
	
	List<UploadFile> findAll();
	UploadFile findById(int id);
	
	int deleteFileById(int id);
}
