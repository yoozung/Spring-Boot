package com.work.wecamp.member.config.oauth.provider;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo {

	private Map<String, Object> attributes; //getAttributes()
	
//	// kakao_account => email 필요
	private Map<String, Object> kakaoAccount;
//    // kakao_account안에 또 profile이라는 JSON객체가 있다. (nickname)
    private Map<String, Object> kakaoProfile;
	
	public KakaoUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
		kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
		kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");
		System.out.println("카카오생성자"+attributes); 
		System.out.println("카카오생성자"+kakaoAccount); 
		System.out.println("카카오생성자"+kakaoProfile); 
	}

	@Override
	public String getProviderId() {
		//return String.valueOf(attributes.get("id"));
		String int1 = String.valueOf(Integer.parseInt(String.valueOf(attributes.get("id"))));
		return int1;
	}

	@Override
	public String getProvider() {
		return "kakao";
	}

	@Override
	public String getEmail() {
		return (String) kakaoAccount.get("email");
	}

	@Override
	public String getName() {
		return (String) kakaoProfile.get("nickname");
	}
	
	@Override
	public String getPhone() {
		return null;
	}
}
