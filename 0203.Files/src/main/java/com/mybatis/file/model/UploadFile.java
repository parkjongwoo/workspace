package com.mybatis.file.model;

public class UploadFile {
	private int id;
	private String writer;
	private String title;
	private String savedFileName;
	private String originalFileName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getSavedFileName() {
		return savedFileName;
	}
	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	@Override
	public String toString() {
		return "File [id=" + id + ", writer=" + writer + ", title=" + title + ", savedFileName=" + savedFileName
				+ ", originalFileName=" + originalFileName + "]";
	}	
}
