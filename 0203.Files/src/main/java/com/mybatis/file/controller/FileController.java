package com.mybatis.file.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.file.form.FileForm;
import com.mybatis.file.model.DownloadFile;
import com.mybatis.file.model.UploadFile;
import com.mybatis.file.service.FileService;

/**
 * File Upload
 * 
 * 1. dependency 추가 : apache common library - pom.xml참조
 * 
 * 2. file url 관리 테이블 생성: 실저장 파일명과 원본 파일명 매칭. 
 * 
 * 3. uploadfile, downloadfile 두 vo 사용
 * 
 * 4. 화면에서 form 객체에 enctype="multipart/form-data" 반드시 추가
 * 
 * 5. 파일 다운로드 처리시, 파일명이 브라우저에서 인식안되는 문제 발생 가능
 * -이에 대비해서 브라우저별 urlencoding 처리
 * @author goott3-4
 *
 */
@Controller
public class FileController {
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value="/fileForm",method=RequestMethod.GET)
	public String fileForm() {
		return "upload";
	}
	
	@RequestMapping(value="/fileupload",method=RequestMethod.POST)
	public String fileupload(FileForm fileForm, Model model) {
		String resultMsg = fileService.save(fileForm);
		model.addAttribute("message", resultMsg);
		return "redirect:/filelist";
	}	
	
	@ResponseBody
	@RequestMapping(value="/filedownload", method=RequestMethod.GET,produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public FileSystemResource filedownload(@RequestParam int id, HttpServletRequest request, HttpServletResponse response) {
		
		DownloadFile downloadFile = fileService.getDownloadFile(id);
		String browser = request.getHeader("User-Agent");
		String downloadFileName = null;
		if(browser.contains("Chrome")||
			browser.contains("MSIE")||
			browser.contains("Trident")) {
			try {				
				downloadFileName = URLEncoder.encode(downloadFile.getOriginalFileName(),"UTF-8").replaceAll("\\+", "%20");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "attachment;filename="+downloadFileName+";");
		}else {
			try {				
				downloadFileName = 
						new String(downloadFile.getOriginalFileName().getBytes("UTF-8"),"ISO-8859-1").replaceAll("\\+", "_");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "attachment;filename="+downloadFileName+";");
		}
		return new FileSystemResource(downloadFile.getFile());
	}
	
	@RequestMapping(value="/filedelete",method=RequestMethod.GET)
	public String deleteFile(@RequestParam int id, Model model) {
		String resultMsg = fileService.deleteFile(id);
		model.addAttribute("message", resultMsg);
		return "redirect:/filelist";
	}
	
	
	@RequestMapping(value="/filelist",method=RequestMethod.GET)
	@ModelAttribute(value="uploadFiles")
	public List<UploadFile> filelist(Model model) {
		return fileService.findAll();
	}
}
