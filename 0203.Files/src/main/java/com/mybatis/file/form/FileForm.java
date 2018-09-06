package com.mybatis.file.form;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author goott3-4
 *
 */
public class FileForm {
	private String writer;
	private String title;
	private MultipartFile uploadFile;
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
}
