package com.company.hello.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hello.member.model.MemberDao;
import com.company.hello.member.model.vo.MemberVo;

@Service //@Component @Repository
// 직관적으로 이해하기 위해서 위에 3개는 동일한 기능을 함
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public int signUpConfirm(MemberVo memberVo) {
		
		System.out.println("[MemberService] signUpConfirm()");
		
		
		System.out.println("m_id : " + memberVo.getM_id());
		System.out.println("m_pw : " + memberVo.getM_pw());
		System.out.println("m_mail : " + memberVo.getM_mail());
		System.out.println("m_phone : " + memberVo.getM_phone());
		
		memberDao.insertMember(memberVo);
		return 0;
	}
	
	public MemberVo signInConfirm(MemberVo memberVo) {
		
		System.out.println("[MemberService] signInConfirm()");
		MemberVo signedInMember = memberDao.selectMember(memberVo);
		return signedInMember;
	}
}