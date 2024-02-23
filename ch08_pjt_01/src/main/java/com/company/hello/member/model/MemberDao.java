package com.company.hello.member.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.company.hello.member.model.vo.MemberVo;

@Repository
public class MemberDao {
	
	private Map<String, MemberVo> memberDB = new HashMap<>();
	
	public void insertMember(MemberVo memberVo) {
		System.out.println("[Memberdao] insertmember()");
		
		System.out.println("m_id : " + memberVo.getM_id());
		System.out.println("m_pw : " + memberVo.getM_pw());
		System.out.println("m_mail : " + memberVo.getM_mail());
		System.out.println("m_phone : " + memberVo.getM_phone());
		
		memberDB.put(memberVo.getM_id(), memberVo);
		printAllMember();
	}
	
	private void printAllMember() {
		System.out.println("[MemberDao] printAllMember()");
		
		Set<String> keys = memberDB.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			MemberVo memberVo = memberDB.get(key);
			
			System.out.println("m_id : " + memberVo.getM_id());
			System.out.println("m_pw : " + memberVo.getM_pw());
			System.out.println("m_mail : " + memberVo.getM_mail());
			System.out.println("m_phone : " + memberVo.getM_phone());
		}
	}
	
	public MemberVo selectMember(MemberVo memberVo) {
		System.out.println("[MemberDao] selectMember()");
		
		MemberVo signedInMember = memberDB.get(memberVo.getM_id());
		if(signedInMember != null && memberVo.getM_pw().equals(signedInMember.getM_pw())) {
			return signedInMember;
		} else {
			return null;
		}
	}
}
