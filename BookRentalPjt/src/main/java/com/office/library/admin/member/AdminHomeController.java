package com.office.library.admin.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	
	private String nextpage;
	@RequestMapping(value= {"","/"}, method = RequestMethod.GET)
	// @RequestMapping({"","/"}) 12번줄 13번줄은 같은 내용
	public String home() {
		System.out.println("[AdminHomeController] home()");
		
		nextpage = "admin/home";
		
		return nextpage;
	}
}
