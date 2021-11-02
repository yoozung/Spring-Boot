package com.work.wecamp.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.wecamp.member.model.Member;


//CRUD JpaRepository안에 있음.
public interface MemberRepository extends JpaRepository<Member, Integer> {
	//Member findByUsername(String username);
	//Member findByMemberid(String memberId);
	
	//select * from member where memberId = 
	
	public Member findByMemberId(String memberId);
	

}
