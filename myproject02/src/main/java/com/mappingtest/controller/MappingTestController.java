package com.mappingtest.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MappingTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MappingTestController.class);
	
	
	@RequestMapping(value="/a", method=RequestMethod.GET)
	public String request01(Locale locale, Model model) {
		
		model.addAttribute("requestMethodName", "request01");
		return "requestResult";
	}
	
	@RequestMapping(value="/b", method=RequestMethod.GET)
	public String request02(Locale locale, Model model) {
		
		model.addAttribute("requestMethodName", "request02");
		return "requestResult";
	}
	
	@RequestMapping(value="/c", method=RequestMethod.GET)
	public String request03(Locale locale, Model model) {
		
		model.addAttribute("requestMethodName", "request03");
		return "requestResult";
	}
}
