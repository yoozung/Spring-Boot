package com.work.wecamp.member.config.auth;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.work.wecamp.member.model.Member;

import lombok.Data;

// /login 주소 요청이 오면 시큐리티 로그인 진행 , 로그인 진행이 완료되면 session 만들어줌. (Security ContextHolder )
// Security Session 에 있는 것을 세션 정보를 get 해서 꺼내면 Authentication 객체가 나온다. 
// 이 안에서 UserDetails 를 꺼내면 User 오브젝트에 접근할 수 있다.
@Data
public class PrincipalDetails implements UserDetails, OAuth2User {
	
	private Member member;
	private Map<String, Object> attributes;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//일반로그인 할때 사용하는 생성자
	public PrincipalDetails(Member member) {
		this.member = member;
	}
	
	//OAuth 로그인 할때 사용하는 생성자
	public PrincipalDetails(Member member, Map<String, Object> attributes) {
		this.member = member;
		this.attributes = attributes;
	}
	
	public Member getMember() {
		return member;
	}

	@Override
	public String getPassword() {
		return member.getMemberPw();
	}

	@Override
	public String getUsername() {
		return member.getMemberId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}


}
