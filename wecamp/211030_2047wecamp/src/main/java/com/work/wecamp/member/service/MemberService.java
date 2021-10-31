package com.work.wecamp.member.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.work.wecamp.member.model.Member;
import com.work.wecamp.member.model.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	/** 로그인 */
	public String login(String memberId, String memberPw) {
		String username = memberDao.login(memberId, memberPw);
		System.out.println("dao username : " + username);
		return username;
	}

	/** 회원가입 */
	public int addMember(Member dto) {
		int result = memberDao.insertMember(dto);
		return result;
	}
	
	   public Member loginToMember(String memberId, String memberPw) {
	         Member dto = memberDao.loginToMember( memberId,  memberPw) ;
	         return dto;
	      }
	
	/** 내 정보 조회*/
	public Member getMemberToDto(String loginMemberId) {
		return memberDao.selectOneToDto(loginMemberId);
	}

	/** 내정보변경저장, 회원정보변경저장 */
	public int setMember(String memberId, String memberPw, String username, String mobile, String email) {
		return memberDao.updateMemberPw(memberId, memberPw, username, mobile, email);
	}
	
	/** 회원탈퇴 */
	 public int deleteMember(Member dto) {
		 int result = memberDao.deleteMember(dto);
		 return result;
	   }

	 /** 아이디 중복체크 */
	 public String idCheck(String memberId) {
		 return memberDao.idCheck(memberId);
	 }
}
