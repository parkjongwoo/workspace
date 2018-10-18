package com.mybatis.file.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.file.form.FileForm;
import com.mybatis.file.model.DownloadFile;
import com.mybatis.file.model.UploadFile;
import com.mybatis.file.repository.FileRepository;
import com.mybatis.file.util.FileUtil;

@Service
public class FileService {
	
	@Autowired
	private FileRepository fileRepository;	
	
	/**
	 * 파일 저장 순서
	 * 1. 저장될 파일명 생성
	 * 2. 파일서버에 저장될 파일명으로 파일 저장
	 * 3. 2가 성공시 원본파일명,저장될파일명 정보를 이용하여 DB저장용 VO 생성
	 * 4. 3으로 DB 저장.
	 * @param fileForm
	 * @return
	 */
	public String save(FileForm fileForm) {		
		String originalFileName = fileForm.getUploadFile().getOriginalFilename();
		String savedFileName = FileUtil.makeSaveFileName(originalFileName);
		boolean uploadResult = false;
		int insertedId = 0;
		UploadFile uploadFile = null;
		
		try {
			uploadResult = FileUtil.saveFile(savedFileName, fileForm.getUploadFile().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(uploadResult) {
			uploadFile = new UploadFile();
			uploadFile.setTitle(fileForm.getTitle());
			uploadFile.setWriter(fileForm.getWriter());
			uploadFile.setSavedFileName(savedFileName);
			uploadFile.setOriginalFileName(originalFileName);
			insertedId = fileRepository.save(uploadFile);
		}		
		 		
//		String msg = result>0?"저장되었습니다.":"저장실패했습니다.";
//		return msg;
		if(insertedId==0)
			return null;
		return FileUtil.getFileDownloadURL(insertedId);
	}
	
	public List<UploadFile> findAll() {		
		return fileRepository.findAll();
	}
	
	public DownloadFile getDownloadFile(int id) {	
		//DB에 저장된 파일정보 로드
		UploadFile fileInfo = fileRepository.findById(id);
		
		//저장되어 있는 파일 참조 가져오기
		File responseFile = FileUtil.getFileFromServer(fileInfo.getSavedFileName());
		
//		System.out.println("responseFile:"+responseFile.getAbsolutePath());
		DownloadFile downloadFile = new DownloadFile();
		downloadFile.setFile(responseFile);
		downloadFile.setOriginalFileName(fileInfo.getOriginalFileName());
		
		return downloadFile;
	}
	
	public String deleteFile(int id) {	
		UploadFile uploadFile = fileRepository.findById(id);
		File deleteFile = FileUtil.getFileFromServer(uploadFile.getSavedFileName());
		int deleteCount = 0;
		
		if(deleteFile.delete()) {
			deleteCount = fileRepository.deleteFileById(id);
		}
		String result = "파일 삭제에 실패하였습니다.";
		
		if(deleteCount>0) {
			result = "파일이 삭제되었습니다.";			
		}
		
		return result;
	}
}
