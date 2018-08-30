package com.mvc.valid.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
//	@Valid 유효성 검사 진행 annotation
//	1.필요dependency: 
//		org.hibernate / hibernate-validator
//		javax.validation / validation-api
//	2.jsp에 태그 적용 : form 태그 추가. ----- member.jsp 참고
//	3.유효성 검사 필요한 method에 유효성검사 관련 dto 파라메터에 @Valid annotation 추가
//	4.3에 이어 파라메터로 BindingResult 추가
//	5.BindingResult.hasErrors()로 검증 통과여부 체크 & 처리
	
	@RequestMapping(value="/member", method=RequestMethod.POST)
	public String addMemberFormFrom(
			@Valid Member member,
			BindingResult bindingResult, 
			Model model ) {
		System.out.println("member");
		if(bindingResult.hasErrors()) {
			return "member/member";
		}
		
		System.out.println("유효성 통과");
		model.addAttribute("message", member.getId()+"님 회원가입되었습니다.");
		
		return "member/result";
	}
}
