package com.work.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.work.dto.Member;

@Service
public class MemberService {
	// ArrayList<Member> 멤버변수 선언 및 생성 : 회원들의 자료 저장구조
	private ArrayList<Member> list = new ArrayList<Member>();
	
	
	// intitMember() 메서드에서 3명의 회원 등록 구현
		
	public MemberService() {
		initMember();
		System.out.println("MemberService() constructor loading");
	}
	
	private void initMember() {
		Member dto1 = Member.builder().memberId("user01").memberPw("password01")
				.name("홍길동").mobile("010-1234-5678").email("user01@work.com")
				.entryDate("2021-07-07").grade("G").mileage(1000).build();
		
		Member dto2 = Member.builder().memberId("user02").memberPw("password02")
				.name("이길동").mobile("010-1234-5555").email("user02@work.com")
				.entryDate("2021-07-07").grade("S").manager("김김가").build();
		
		Member dto3 = Member.builder().memberId("user05").memberPw("password05")
				.name("삼길동").mobile("010-1234-5678").email("user05@work.com")
				.entryDate("2021-07-07").grade("A").build();
		
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
	}
	
	public int getSize() {
		return list.size();
	}

	/** 로그인 */
	public String login(String memberId, String memberPw) {
		for (Member dto : list) {
			if (dto.getMemberId().equals(memberId) && dto.getMemberPw().equals(memberPw)) {
				return dto.getGrade();
			}
		}
		return null;
	}
}
