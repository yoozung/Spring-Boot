package com.work.wecamp.member.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.work.wecamp.member.model.Member;
import com.work.wecamp.member.repository.MemberRepository;
import com.work.wecamp.member.service.MemberService;


// Security confing 의 loginProcessingUrl("/login");
// loadUserByUsername 실행
@Service
public class PrincipalDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	//시큐리티 세션 = Authentication = UserDetails
	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		System.out.println("memberId: "+memberId);
		Member memberEntity = memberRepository.findByMemberId(memberId);
		System.out.println("==============="+memberEntity);
		
		if(memberEntity != null) {
			System.out.println("==============1234"+new PrincipalDetails(memberEntity));
			
			return new PrincipalDetails(memberEntity); 
			//UserDetails 가Authentication 내부에 들어감 그리고 session 안에 Authentication가 들어감
		}
		return null;
	}
	
	
	

	
}
