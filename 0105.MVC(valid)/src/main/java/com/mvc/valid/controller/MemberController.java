package com.mvc.valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.valid.model.Member;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping(value="/member",method=RequestMethod.GET)
	public String createMember() {
		
		return "member/member";
	}
	
	@RequestMapping(value="/member", method=RequestMethod.POST)
	public String addMemberFormFrom(Member member, Model model) {
		model.addAttribute("message", member.getId()+"님 회원가입되었습니다.");
		
		return "member/result";
	}
}
