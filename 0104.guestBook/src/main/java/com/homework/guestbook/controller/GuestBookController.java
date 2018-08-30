package com.homework.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.homework.guestbook.dao.guestbook.GuestBookDao;
import com.homework.guestbook.model.GuestBookItem;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/guestbook/*")
public class GuestBookController {
	
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	@Autowired
	private GuestBookDao dao;
	
	public void setDao(GuestBookDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/inputForm", method=RequestMethod.GET)
	public void inputForm() {
		System.out.println("inputForm 도착");
	}
	
	@ModelAttribute("guestbookItem")
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public GuestBookItem detail(@RequestParam int num) {
		GuestBookItem item = dao.selectById(num);
		
		return 	item;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@ModelAttribute("guestbookItemList")
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public List<GuestBookItem> select() {
		System.out.println("select 도착");
		List<GuestBookItem> list = dao.selectAll();		
		return list;	
	}
	
	@ModelAttribute("guestbookItemList")
	@RequestMapping(value="/listPage", method=RequestMethod.POST)
	public List<GuestBookItem> select2() {
		System.out.println("select 도착");
		List<GuestBookItem> list = dao.selectAll();		
		return list;	
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestBookItem item, Model model) {
		boolean result = dao.insert(item);
		String msg = result?"추가되었습니다.":"추가 실패하였습니다.";
		model.addAttribute("msg", msg);
		return 	"forward:listPage";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@ModelAttribute GuestBookItem item, Model model) {
		boolean result = dao.update(item);
		String msg = result?"변경되었습니다.":"변경 실패하였습니다.";
		model.addAttribute("msg", msg);
		return 	"forward:listPage";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam int num, Model model) {
		boolean result = dao.delete(num);
		String msg = result?"삭제되었습니다.":"삭제 실패하였습니다.";
		model.addAttribute("msg", msg);
		return 	"forward:listPage";
	}
}

