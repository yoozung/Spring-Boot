package com.work.wecamp.member.config.oauth.provider;

import java.util.Map;

public class NaverUserInfo implements OAuth2UserInfo {

	private Map<String, Object> attributes; //getAttributes()
	
	public NaverUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
		System.out.println("네이버생성자"+attributes); 
	}
	
	@Override
	public String getProviderId() {
		return (String) attributes.get("id");
	}

	@Override
	public String getProvider() {
		return "naver";
	}

	@Override
	public String getEmail() {
		return (String) attributes.get("email");
	}

	@Override
	public String getName() {
		return (String) attributes.get("name");
	}
	
	@Override
	public String getPhone() {
		return (String) attributes.get("mobile");
	}
	
	
	

}
