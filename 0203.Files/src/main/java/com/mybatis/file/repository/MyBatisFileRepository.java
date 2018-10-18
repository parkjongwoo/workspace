package com.mybatis.file.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.file.mapper.FileMapper;
import com.mybatis.file.model.UploadFile;

@Repository
public class MyBatisFileRepository implements FileRepository {
	
	@Autowired
	private FileMapper fileMapper;
	
	@Override
	public int save(UploadFile uploadFile) {
		// insert 후 insert된 튜플의 id를 반환
		fileMapper.save(uploadFile);
		return uploadFile.getId();
	}

	@Override
	public List<UploadFile> findAll() {		
		return fileMapper.findAll();
	}

	@Override
	public UploadFile findById(int id) {		
		return fileMapper.findById(id);
	}

	@Override
	public int deleteFileById(int id) {		
		return fileMapper.deleteFileById(id);
	}
	
}
