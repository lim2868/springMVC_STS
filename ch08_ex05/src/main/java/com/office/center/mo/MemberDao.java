package com.office.center.mo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.office.center.mo.dto.MemberDto;

@Repository
public class MemberDao {
	
	private Map<String, MemberDto> memberDB = new HashMap<String, MemberDto>();
	
	public void insertMember(MemberDto m) {
			
		System.out.println("[MemberDao] insertMember");
		
		System.out.println("m_id : " + m.getM_id());
		System.out.println("m_pw : " + m.getM_pw());
		System.out.println("m_name : " + m.getM_name());
		
		memberDB.put(m.getM_id(), m);
		this.printAllMembers();
	}
	
	private void printAllMembers(){
		
		System.out.println("[MemberDao] printAllMembers");
		Set<String> keys = memberDB.keySet();
		
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			MemberDto m = memberDB.get(iterator.next());
			
			System.out.println("m_id : " + m.getM_id());
			System.out.println("m_pw : " + m.getM_pw());
			System.out.println("m_name : " + m.getM_name());
		}
	}
}
