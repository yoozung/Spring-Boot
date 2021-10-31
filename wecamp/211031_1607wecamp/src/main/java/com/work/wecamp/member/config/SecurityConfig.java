package com.work.wecamp.member.config;

import org.springframework.beans.factory.annotation.Autowired;

//구글로그인이 완료된 뒤 후처리 필요. 1. 코드받기(인증), 2. 액세스토큰(권한), 
//3. 사용자프로필 정보 가져오고, 4-1. 그 정보를 토대로 회원가입을 자동으로 진행
//4-2 (이메일, 전화번호, 이름, 아이디) 이외의 정보가 필요할시 추가적인 회원가입창 나오기.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.work.wecamp.member.config.auth.PrincipalDetailsService;
import com.work.wecamp.member.config.oauth.PrincipalOauth2UserService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private PrincipalOauth2UserService principalOauth2UserService;
	
	@Autowired
	private PrincipalDetailsService principalDetailsService;
	
	
	
	// 해당메서드의 리턴 오브젝트를 IoC로 등록
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/member/**").authenticated() //인증만되면 들어갈수 있는주소
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.loginPage("/loginForm")
			.usernameParameter("memberId")
			.passwordParameter("memberPw")
			.loginProcessingUrl("/login")  //액션태크
			.defaultSuccessUrl("/member/login") //로그인 성공시
			.and()
			.oauth2Login()
			.loginPage("/loginForm")
			.defaultSuccessUrl("/member/login")
			.userInfoEndpoint()
			.userService(principalOauth2UserService);
	}
	
//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(principalDetailsService).passwordEncoder(passwordEncoder());
//    }
}
