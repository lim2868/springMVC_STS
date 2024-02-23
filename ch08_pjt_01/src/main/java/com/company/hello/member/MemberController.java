package com.company.hello.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.hello.member.model.vo.MemberVo;
import com.company.hello.member.service.MemberService;

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
	
	@RequestMapping("/test")
	@ResponseBody
	public String tset() {
		return "<h2>This is a test page with h2 tag</h2>";
	}
	
	
	@RequestMapping("/signUpconfirm")
	public String signUpConfirm(MemberVo memberVo) {
		System.out.println("[MemberController] signUpConfirm()" );
		
		System.out.println("m_id : " + memberVo.getM_id());
		System.out.println("m_pw : " + memberVo.getM_pw());
		System.out.println("m_mail : " + memberVo.getM_mail());
		System.out.println("m_phone : " + memberVo.getM_phone());
		
		memberService.signUpConfirm(memberVo);
		
		return "sign_up_ok";
	}
	
	@RequestMapping("/signInConfirm")
	public String signInConFirm(MemberVo memberVo) {
		System.out.println("[MemberController] signInConfirm()");
		MemberVo signedInMember = memberService.signInConfirm(memberVo);
		if(signedInMember != null) {
			return "sign_in_ok";
		} else {
			return "sign_in_ng";
		}
	}
	
	
	//ResponseBody return 문자 그대로를 클라이언트에게 보여줌
	
	//RequestMapping /test라는 주소에게 return 뷰 페이지를 넘겨줌
}