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

import com.homework.guestbook.model.GuestBookItem;
import com.homework.guestbook.service.GuestBookService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/guestbook/*")
public class GuestBookController {
	
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
//	@Autowired
//	private GuestBookservice service;
//	public void setservice(GuestBookservice service) {
//		this.service = service;
//	}
	
	@Autowired
	private GuestBookService service;
	
	
	@RequestMapping(value="/inputForm", method=RequestMethod.GET)
	public void inputForm() {
		System.out.println("inputForm 도착");
	}
	
	@ModelAttribute("guestbookItem")
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public GuestBookItem detail(@RequestParam int num) {
		GuestBookItem item = service.selectById(num);
		
		return 	item;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@ModelAttribute("guestbookItemList")
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public List<GuestBookItem> select() {
		System.out.println("select 도착");
		List<GuestBookItem> list = service.selectAll();		
		return list;	
	}
	
	@ModelAttribute("guestbookItemList")
	@RequestMapping(value="/listPage", method=RequestMethod.POST)
	public List<GuestBookItem> select2() {
		System.out.println("select 도착");
		List<GuestBookItem> list = service.selectAll();		
		return list;	
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestBookItem item, Model model) {
		String msg = service.insert(item);
		model.addAttribute("msg", msg);
		return 	"forward:listPage";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@ModelAttribute GuestBookItem item, Model model) {
		String msg = service.update(item);
		model.addAttribute("msg", msg);
		return 	"forward:listPage";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam int num, Model model) {
		String msg = service.delete(num);
		model.addAttribute("msg", msg);
		return 	"forward:listPage";
	}
}

