package com.mybatis.file.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class FileUtil {
	//기본 파일저장 폴더
	public static final String UPLOAD_PATH="f:\\fileuploadtest\\upload";
	
	public static String makeSaveFileName(String originalFileName) {		
		UUID uid = UUID.randomUUID();
		String saveFileName = uid.toString()+"_"+originalFileName;		
		return saveFileName;
	}
	
	public static boolean saveFile(String saveFileName, byte[] fileData) {
		File target = new File(UPLOAD_PATH,saveFileName);
		boolean result = false;
		try {
			FileCopyUtils.copy(fileData, target);
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//파일 서버에서 저장된 파일 가져오기
	public static File getFileFromServer(String fileName) {
		File downLoadFile = new File(UPLOAD_PATH, fileName);
		return downLoadFile;		
	}
}
