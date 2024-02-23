package com.office.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.center.mo.dto.MemberDto;
import com.office.center.service.MemberService;
	

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/signUp")
	public String signup() {
		return "sign_up";
	}
	
	@RequestMapping("/signIn")
	public String signIn() {
		return "sign_in";
	}
	
	@RequestMapping("/signUpconfirm")
	public String memJoin(MemberDto m) {
		System.out.println("[MemberController] memJoin()");
		System.out.println("m_id : " + m.getM_id());
		System.out.println("m_pw : " + m.getM_pw());
		System.out.println("m_name : " + m.getM_name());
		memberService.signUpConfirm(m);
		return "sign_up_ok";
	}
}