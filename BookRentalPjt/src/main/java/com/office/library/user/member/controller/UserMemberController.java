package com.office.library.user.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.library.user.member.mo.UserMemberService;
import com.office.library.user.member.mo.vo.UserMemberVo;

@Controller
@RequestMapping("/user/member")
public class UserMemberController {

	String nextPage = "";
	@Autowired
	UserMemberService userMemberService;
	
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		System.out.println("[UserMemberController] createAccountForm()");
		nextPage = "user/member/create_account_form";
		return nextPage;
	}
	
	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(UserMemberVo userMemberVo) {
		System.out.println("[UserMemberController] createAccountConfirm()");
		nextPage = "user/member/create_account_ok";
		int result = userMemberService.createAccountConfirm(userMemberVo);
		
		if(result<=0) {
			nextPage="user/member/create_account_ng";
		}
		return nextPage;
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("[UserMemberController] loginForm()");
		
		nextPage = "user/member/login_form";
		
		return nextPage;
	}
	
	@PostMapping("/loginConfirm")
	public String loginConfirm(UserMemberVo userMemberVo, HttpSession session) {
		System.out.println("[UserMemberController] loginConfirm()");
		
		nextPage = "user/member/login_ok";
		UserMemberVo loginedUserMemberVo = 
				userMemberService.loginConfirm(userMemberVo);
		if(loginedUserMemberVo == null) {
			nextPage = "user/member/login_ng";
		} else {
			session.setAttribute("loginedUserMemberVo", loginedUserMemberVo);
			session.setMaxInactiveInterval(60*30);
		}
		return nextPage;
	}
	
	@GetMapping("/modifyAccountForm")
	public String modifyAccountForm(HttpSession session) {
		System.out.println("[UserMemberController] modifyAccountForm()");
		
		nextPage = "user/member/modify_account_form";
		
//		UserMemberVo loginedUserMemberVo = 
//				(UserMemberVo) session.getAttribute("loginedUsermemberVo");
//		if(loginedUserMemberVo == null) {
//			nextPage="redirect:/user/member/loginForm";
//		}
		return nextPage;
	}
	
	@PostMapping("/modifyAccountConfirm")
	public String modifyAccountConfirm(UserMemberVo userMemberVo, HttpSession session) {
		System.out.println("[UserMemberController] modifyAccountConfirm()");
		
		String nextPage = "user/member/modify_account_ok";
		
		int result = userMemberService.modifyAccountConfirm(userMemberVo);
		
		if(result > 0) {
			UserMemberVo loginedUserMemberVo = userMemberService.getLoginedUserMemberVo(userMemberVo.getU_m_no());
			
			session.setAttribute("loginedUserMemberVo", loginedUserMemberVo);
			session.setMaxInactiveInterval(60*30);
		} else {
			nextPage = "user/member/modify_account_ng";
		}
		return nextPage;
	}
	
	@GetMapping("/logoutConfirm")
	public String logoutConfirm(HttpSession session) {
		System.out.println("[UserMemberController] logoutConfirm()");
		
		nextPage = "redirect:/";
		session.invalidate();
		return nextPage;
	}
	
	@GetMapping("/findPasswordForm")
	public String findpasswordForm() {
		System.out.println("[UsermemberController] findPasswordForm()");
		nextPage = "user/member/find_password_form";
		return nextPage;
	}
	
	@PostMapping("/findPasswordConfirm")
	public String findPasswordConfirm(UserMemberVo userMemberVo) {
		System.out.println("[UserMemberController] findPasswordConfirm()");
		
		nextPage = "user/member/find_password_ok";
		
		int result = userMemberService.findPasswordConfirm(userMemberVo);
		
		if(result <= 0) {
			nextPage ="user/member/find_password_ng";
		}
		return nextPage;
	}
}