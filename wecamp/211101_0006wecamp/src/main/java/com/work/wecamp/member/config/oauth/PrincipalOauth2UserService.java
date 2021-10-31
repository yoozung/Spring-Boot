package com.work.wecamp.member.config.oauth;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.work.wecamp.member.config.auth.PrincipalDetails;
import com.work.wecamp.member.config.oauth.provider.GoogleUserInfo;
import com.work.wecamp.member.config.oauth.provider.KakaoUserInfo;
import com.work.wecamp.member.config.oauth.provider.NaverUserInfo;
import com.work.wecamp.member.config.oauth.provider.OAuth2UserInfo;
import com.work.wecamp.member.model.Member;
import com.work.wecamp.member.repository.MemberRepository;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MemberRepository memberRepository;
	
	//구글로 부터 받은 userRequset 데이터에 대한 후처리
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("getClientRegistration : "+userRequest.getClientRegistration());//registrationId로 어떤 oauth로 로그인한지 확인
		System.out.println("getAccessToken : "+userRequest.getAccessToken().getTokenValue());
		
		
		OAuth2User oauth2User = super.loadUser(userRequest);
		// 구글로그인 버튼 클릭 -> 구글로그인창 -> 로그인을 완료 -> code를 리턴(oauth-client라이브러리) -> Access token요청
		// userRequest 정보 -> loadUser함수 -> 구글로부터 회원프로필 받아줌
		System.out.println("getAttributes : "+oauth2User.getAttributes());
		
		//return super.loadUser(userRequest);
		
		
		//구글,네이버,카카오 OAuth로그인
		OAuth2UserInfo oAuth2UserInfo = null;
		if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			System.out.println("구글 로그인 요청");
			oAuth2UserInfo = new GoogleUserInfo(oauth2User.getAttributes());
		}else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
			System.out.println("네이버 로그인 요청");	
			oAuth2UserInfo = new NaverUserInfo((Map)oauth2User.getAttributes().get("response"));
			System.out.println("===="+oAuth2UserInfo);
			System.out.println("===="+(Map)oauth2User.getAttributes().get("response"));
		}else if(userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
			System.out.println("카카오 로그인 요청");
			oAuth2UserInfo = new KakaoUserInfo(oauth2User.getAttributes());
			
			//System.out.println("카카오id"+((Map)oauth2User.getAttributes()).get("id"));
			//System.out.println(oAuth2UserInfo.getProviderId());
			// kakao_account => email 필요
			
			//Map<String, Object> kakaoAccount = (Map)oauth2User.getAttributes().get("kakao_account");
		    // kakao_account안에 또 profile이라는 JSON객체가 있다. (nickname)
		    //Map<String, Object> kakaoProfile = (Map)kakaoAccount.get("profile");
		    
		    //System.out.println(kakaoAccount);
			//oAuth2UserInfo = new KakaoUserInfo((Map)oauth2User.getAttributes());
			

		}else {
			System.out.println("소셜로그인은 구글,네이버,카카오만 지원 가능합니다.");
		}

		
		String provider = oAuth2UserInfo.getProvider(); //google
		String providerId = oAuth2UserInfo.getProviderId();
		String memberId = provider+"_"+providerId;
		String memberPw = bCryptPasswordEncoder.encode("겟인데어");
		String username = oAuth2UserInfo.getName(); 
		String email = oAuth2UserInfo.getEmail();
		String mobile = oAuth2UserInfo.getPhone();
		
		Member memberEntity = memberRepository.findByMemberId(memberId);
		
		
		
		
		if(memberEntity == null) {
			System.out.println("OAuth 로그인 최초입니다.");
			memberEntity = Member.builder()
					.memberId(memberId)
					.memberPw(memberPw)
					.username(username)
					.email(email)
					.mobile(mobile)
					.provider(provider)
					.providerId(providerId)
					.build();
			memberRepository.save(memberEntity);		
		}else {
			System.out.println("로그인을 이미 한적이 있습니다. 당신은 자동회원가입이 되어 있습니다.");
		}
		
		return new PrincipalDetails(memberEntity, oauth2User.getAttributes());
		
		
	}

}
