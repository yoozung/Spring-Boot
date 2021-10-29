package com.work.wecamp.member.controller;

import java.io.IOException;



import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import com.work.wecamp.member.repository.MemberRepository;
import com.work.wecamp.member.config.auth.PrincipalDetails;
import com.work.wecamp.member.model.Member;
import com.work.wecamp.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	public MemberService memberservice;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/** 메인화면 */
	@GetMapping({"", "/"})
	public String main() {
		return "/main"; 
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	
	@GetMapping("/member/deleteForm")
	public String deleteForm(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
		Member dto = principalDetails.getMember();
		model.addAttribute("memberId",dto.getMemberId());
		model.addAttribute("memberPw",dto.getMemberPw());
		return "member/deleteForm";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam(value = "memberPw") String memberPw, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
		System.out.println("==========myinfoupdate요청  memberPw: "+memberPw);
		Member dto = principalDetails.getMember();
		
		
		if(bCryptPasswordEncoder.matches(memberPw, dto.getMemberPw())) {
			memberRepository.delete(dto);
		} else {
			System.out.println("비밀번호가 틀렸습니다 다시확인해주시기 바랍니다.");
		}
//		
//		dto.getMemberPw()
//		System.out.println("변경전 dto: "+dto);
//		
//		
//		System.out.println("비밀번호변경후 dto: "+dto);
		
		return "main"; // 함수호출
	}
	
	@PostMapping("/join")
	public String join(Member member) {
		System.out.println(member);
		//암호화
		String rawPassword = member.getMemberPw();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		member.setMemberPw(encPassword);
		memberRepository.save(member);
		return "loginForm"; // 함수호출
	}
	
	@PostMapping("/myInfoUpdate")
	public String myInfoUpdate(@RequestParam(value = "memberPw") String memberPw, @RequestParam(value = "username") String username, @RequestParam(value = "email") String email, @RequestParam(value = "mobile") String mobile, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
		System.out.println("==========myinfoupdate요청  memberPw: "+memberPw);
		Member dto = principalDetails.getMember();
		System.out.println("변경전 dto: "+dto);
		
		String encPassword = bCryptPasswordEncoder.encode(memberPw);
		dto.setMemberPw(encPassword);
		dto.setUsername(username);
		dto.setEmail(email);
		dto.setMobile(mobile);
		memberRepository.save(dto);
		System.out.println("비밀번호변경후 dto: "+dto);
		
		return "main"; // 함수호출
	}
	
	@GetMapping("/member/login")
	public String login(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {

		//		System.out.println("==member/login: memberId "+memberId);
//		System.out.println("==member/login: memberPw"+memberPw);
		Member dto = principalDetails.getMember();
		//String username = dto.getUsername();
		model.addAttribute("username",dto.getUsername());
		return "member/login";
	}
	
	@GetMapping("/member/myInfo")
	public String doGet(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
		
		Member dto = principalDetails.getMember();
		//String username = dto.getUsername();
		model.addAttribute("memberId",dto.getMemberId());
		model.addAttribute("username",dto.getUsername());
		model.addAttribute("email",dto.getEmail());
		model.addAttribute("mobile",dto.getMobile());
		return "member/myInfo";
	
	}
	
	/** 아이디 중복 체크 */
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception{
				
		String result = memberservice.idCheck(memberId);
				
		if(result != null) {
			return "fail";	// 중복 아이디가 존재
		} else {
			return "success";	// 중복 아이디 x
		}				
	} 
	

	
	/**
	@GetMapping("/member/login")
	public @ResponseBody String testLogin(Authentication authentication,
			@AuthenticationPrincipal PrincipalDetails userDetails) {// DI (의존성주입)
		System.out.println("/member/login ==================");
		PrincipalDetails principalDetails =(PrincipalDetails) authentication.getPrincipal();
		//두가지방법
		System.out.println("authentication :" + principalDetails.getMember());
		System.out.println("userDetails: "+ userDetails.getMember());
		return "세션 정보 확인하기";
	}
	
	@GetMapping("/member/oauth/login")
	public @ResponseBody String testOAuthLogin(Authentication authentication,
			@AuthenticationPrincipal OAuth2User oauth) {// DI (의존성주입)
		System.out.println("/member/oauth/login ==================");
		OAuth2User oAuth2User =(OAuth2User) authentication.getPrincipal();
		//두가지방법
		System.out.println("authentication :" + oAuth2User.getAttributes());
		System.out.println("Oauth2User: "+oauth.getAttributes());
		return "OAuth 세션 정보 확인하기";
	}
	**/
	
	/** 회원가입 양식 */
	/*
	@RequestMapping("/member/joinForm")
	public String joinForm(Model model, HttpSession session) {
		return "member/joinForm";
	}
	*/
	
	/** 회원가입 */
	/*
	@RequestMapping("/member/join")
	public String insertMember(Member dto, Model model) {
		int joinresult = memberservice.addMember(dto);
		if(joinresult == 1) {
			model.addAttribute("joinresult",joinresult);
			return "member/loginForm";
		}else {
			model.addAttribute("message", "[회원가입실패]");
			return "member/main";
		}
	}
	*/
	
	
	
	/** 로그인 양식 */
	/*
	@RequestMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	*/
	
	
	
	/** 로그인 */
	/*
	@RequestMapping("/member/login")
	  public String login(String memberId , String memberPw, HttpSession session, Model model) {
        
        String username = memberservice.login(memberId, memberPw);
        
        Member dto = memberservice.loginToMember(memberId,memberPw);
        
        if(username != null) {
           
           session.setAttribute("memberId", memberId);
           session.setAttribute("username", username);
           session.setAttribute("dto", dto);
           
           return "main";
        }else {
        	model.addAttribute("loginCheck",true);
           return "main";
        }
     }
     
     */
	
	
	
	
	
	
	
//	/** 회원 탈퇴 양식 */
//	@RequestMapping("/member/deleteForm")
//	public String deleteForm(Model model, HttpSession session) {
//		return "member/deleteForm";
//	}
//	
//	/** 회원 탈퇴 */
//	@RequestMapping("/member/delete")
//	public String deleteMember(Member dto, HttpSession session, Model model) {
//		System.out.println(dto.getMemberPw());
//		int result = memberservice.deleteMember(dto);
//		if(result == 1) {
//			Enumeration<String> attributes = session.getAttributeNames();
//			while(attributes.hasMoreElements()) {
//				String attribute = (String) attributes.nextElement();
//				session.removeAttribute(attribute);
//			}
//			session.invalidate();
//			model.addAttribute("result", result);
//			return "main";
//		}else {
//			model.addAttribute("deleteCheck", true);
//			return "member/main";
//		}
//	}
//	
//	/** 로그아웃 */
//	@RequestMapping("/member/logout")
//	public String logout(HttpSession session) {
//		Enumeration<String> attributes = session.getAttributeNames();
//		while(attributes.hasMoreElements()) {
//			String attribute = (String) attributes.nextElement();
//			session.removeAttribute(attribute);
//		}
//		session.invalidate();
//		return "main";
//	}
	
//	@GetMapping("/member/logout")
//	public String logout(@AuthenticationPrincipal PrincipalDetails principalDetails) {
//		
//		return null;
//	}

	
//	/** 내정보조회 */
//	@RequestMapping("/member/myInfo")
//	protected String doGet(HttpServletRequest request) throws ServletException, IOException {
//		
//		// 기존 세션객체 가져오기
//		HttpSession session = request.getSession(false);
//		
//		// 사용자 인증 검증 : 오류 처리
//		if (session == null || session.getAttribute("memberId") == null || session.getAttribute("username") == null) {
//			return "member/result";
//		}
//		
//		// 세션객체에 설정되어 있는 로그인 사용자 아이디 가져오기
//		String loginMemberId = (String)session.getAttribute("memberId");
//		
//		Member dto = memberservice.getMemberToDto(loginMemberId);
//		
//		if (dto == null) {
//			return "member/main";
//		}
//		request.setAttribute("dto", dto);
//		return "member/myInfo";
//	}
	
	
	
	
	
//	/** 내정보 변경 */
//	@RequestMapping("member/myInfoUpdate")
//	public String updateInfo(HttpServletResponse response, HttpSession session, String memberId, String memberPw, String username, String mobile, String email, Model model) throws IOException {
//		if (session == null || session.getAttribute("memberId") == null || session.getAttribute("username") == null) {
//			return "member/main";
//		}
//		
//		response.setContentType("text/html;charset=utf-8");
//		
//		if (!isRequired(memberId) || !isRequired(memberPw) || !isRequired(username) ||
//				!isRequired(mobile) || !isRequired(email)) {
//			return "member/myInfo";
//		}
//		
//		int updateresult = memberservice.setMember(memberId, memberPw, username, mobile, email); 
//		System.out.println(updateresult);
//		if (updateresult >= 1) {
//			Enumeration<String> attributes = session.getAttributeNames();
//			while(attributes.hasMoreElements()) {
//				String attribute = (String) attributes.nextElement();
//				session.removeAttribute(attribute);
//			}
//			session.invalidate();
//			model.addAttribute("updateresult", updateresult);
//			return "/main";
//		} else {
//		}
//		return "member/main";
//	}
//	
//	/** 내정보변경 시 사용하는 변수 */
//	public boolean isRequired(String data) {
//		if (data != null && data.trim().length() > 0) {
//			return true;
//		}
//		return false;
//	}
//	
	
//	
}
