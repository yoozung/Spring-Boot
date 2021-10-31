package com.work.wecamp.member.model;

import org.apache.ibatis.annotations.Mapper;


import com.work.wecamp.member.model.Member;


@Mapper
public interface MemberDao {
	/** 로그인 */
	public String login(String memberId, String memberPw);
	
	/** 회원상세 조회 */
	public Member selectMember();
	
	/** 회원가입 */
	public int insertMember(Member dto);
	
	/** 로그인 도메인 반환 */
	public Member loginToMember(String memberId, String memberPw);

	/** 내정보 조회 */
	public Member selectOneToDto(String loginMemberId);

	/** 내정보 변경 */
	public int updateMemberPw(String memberId, String memberPw, String username, String mobile, String email);
	
	/** 회원 탈퇴 */
	public int deleteMember(Member dto);
	
	/** 아이디 중복 체크 */
	public String idCheck(String memberId);

	
}
