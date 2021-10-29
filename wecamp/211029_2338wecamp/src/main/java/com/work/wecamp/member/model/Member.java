package com.work.wecamp.member.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원 도메인 클래스
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ" , initialValue = 1, allocationSize = 1)
public class Member {
	@Id //pk
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
	
	private String member_no;
	private String memberId;
	private String memberPw;
	private String username;
	private String email;
	private String mobile;
	
	private String provider;
	private String providerId;
	@CreationTimestamp
	private Timestamp createDate; //자동시간 생성
	
	@Builder
	public Member(String memberId, String memberPw, String username, String email, String mobile, String provider,
			String providerId, Timestamp createDate) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.provider = provider;
		this.providerId = providerId;
		this.createDate = createDate;
	}
}
