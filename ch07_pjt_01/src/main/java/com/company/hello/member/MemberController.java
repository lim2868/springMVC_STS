package com.company.hello.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
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
	
	//ResponseBody return 문자 그대로를 클라이언트에게 보여줌
	
	//RequestMapping /test라는 주소에게 return 뷰 페이지를 넘겨줌
}