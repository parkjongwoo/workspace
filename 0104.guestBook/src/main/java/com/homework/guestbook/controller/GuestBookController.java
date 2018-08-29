package com.homework.guestbook.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/guestbook/*")
public class GuestBookController {
	
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/select", method=RequestMethod.GET)
	public void select() {
		
		
		
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public void insert() {
		
		
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public void delete() {
		
		
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void update() {
		
		
		
	}
	
}

