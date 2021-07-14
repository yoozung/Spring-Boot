package com.work.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/** 회원 도메인 클래스 9개 속성 정의 
 * toString() 재정의시 : 비밀번호, 휴대폰은 제외 
 */
//@Data
@Setter
@Getter
@ToString(exclude = {"memberPw", "mobile"}, includeFieldNames = false)
@NoArgsConstructor
@Builder 
@AllArgsConstructor
public class Member {
	private String memberId;
	private String memberPw;
	private String name;	
	private String mobile;	
	private String email;	
	private String entryDate;	
	private String grade;	
	private int mileage;	
	private String manager;
	
	
//	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
//			String grade, int mileage, String manager) {
//		// 선행처리 로직 수행
//		this.memberId = memberId;
//		this.memberPw = memberPw;
//		this.name = name;
//		this.mobile = mobile;
//		this.email = email;
//		this.entryDate = entryDate;
//		this.grade = grade;
//		this.mileage = mileage;
//		this.manager = manager;
//	}	
	
	
}
