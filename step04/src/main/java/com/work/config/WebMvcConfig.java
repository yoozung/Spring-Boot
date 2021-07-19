package com.work.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	// DI 인터셉터 객체 : 다중의 인스턴스인 경우에는 qualifier 사용하여 해당 instance 지정
	@Autowired
	@Qualifier("beforeActionInterceptor")
	HandlerInterceptor beforeActionInterceptor;
	
	@Autowired
	@Qualifier("needToLoginInterceptor")
	HandlerInterceptor needToLoginInterceptor;
	
	@Autowired
	@Qualifier("needToAdminInterceptor")
	HandlerInterceptor needToAdminInterceptor;
	
	@Autowired
	@Qualifier("needToLogoutInterceptor")
	HandlerInterceptor needToLogoutInterceptor;

	// 인터셉터 클래스와 자원 및 요청들에 대한 인터셉터를 연결추가 설정 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 1. beforeActionInterceptor : 사용자인증, 관리자권한 정보 설정위한 인터셉터
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**")
		.excludePathPatterns("/css/**").excludePathPatterns("/js/**").excludePathPatterns("/img/**");
		// .excludePathPatterns("/resource/**");	파일구조 이런식으로 하면 관리가 더 편하다
		
		// 2. needToLoginInterceptor : 로그인 체킹 인터셉터 
		registry.addInterceptor(needToLoginInterceptor).addPathPatterns("/**")		
		.excludePathPatterns("/css/**").excludePathPatterns("/js/**").excludePathPatterns("/img/**")
		.excludePathPatterns("/").excludePathPatterns("/main")
		.excludePathPatterns("/loginForm").excludePathPatterns("/login")
		.excludePathPatterns("/joinForm").excludePathPatterns("/join");
		
		// 3. needToLogoutInterceptor : 로그아웃 체킹 인터셉터 | 로그인 상태에서 사용해선 안됨
		registry.addInterceptor(needToLogoutInterceptor)
		.addPathPatterns("/login").addPathPatterns("/loginForm")
		.addPathPatterns("/join").addPathPatterns("/joinForm");
		
		// 4. needToAdminInterceptor 
		registry.addInterceptor(needToAdminInterceptor)
		.addPathPatterns("/memberList");	//.addPathPatterns("/memberDetail")
		// .addPathPatterns("admin/**")
		
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
}
