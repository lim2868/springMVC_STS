package com.office.center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.center.mo.MemberDao;
import com.office.center.mo.dto.MemberDto;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	public void signUpConfirm(MemberDto m) {
		
		System.out.println("[MemberService] signUpConfirm()");
		
		System.out.println("m_id : " + m.getM_id());
		System.out.println("m_pw : " + m.getM_pw());
		System.out.println("m_name : " + m.getM_name());
		
		memberDao.insertMember(m);
	}
}
