package com.work.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.dto.Member;
import com.work.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	public MemberService memberService;
	
	// 응답페이지 이동 : jsp
	// application.properties
	// spring.mvc.view.prefix=/WEB-INF/jsp/
	// spring.mvc.view.suffix=.jsp
	@RequestMapping("/main")
	public String main() {
		return "main"; // /WEB-INF/jsp/main.jsp
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}


	
	@RequestMapping("/join")
	public String join(Member dto, Model model) {
		System.out.println("회원가입요청");
		System.out.println(dto);
		
		String memberId = dto.getMemberId();
		String memberPw = dto.getMemberPw();
		String name =  dto.getName();
		String mobile =  dto.getMobile();
		String email =  dto.getEmail();
		
		Map<String, String> dtoMap = new LinkedHashMap<String, String>();
		dtoMap.put("memberId", memberId);
		dtoMap.put("memberPw", memberPw);
		dtoMap.put("name", name);
		dtoMap.put("mobile", mobile);
		dtoMap.put("email", email);
		
		System.out.println(dtoMap);
		
		if (dtoMap != null) {
			model.addAttribute("message", "[회원가입 성공]" + name);
		} else {
			model.addAttribute("message", "[회원가입 실패]");
		}
		
		return "result";
	}
	
//	@RequestMapping("/login")
//	public void login(HttpServletRequest request) {
//		System.out.println("로그인요청");
//		String memberId = request.getParameter("memberId");
//		String memberPw = request.getParameter("memberPw");
//		System.out.println(memberId + ", " + memberPw);
//		//return null;
//	}
	
	@RequestMapping("/login")
	public String login(String memberId, String memberPw, Model model) {
		System.out.println("로그인요청");
		System.out.println(memberId + ", " + memberPw);
		
		String grade = memberService.login(memberId, memberPw);
		System.out.println("login grade : " + grade);
	
		if (grade != null) {
			model.addAttribute("message", "[로그인 사용자]" + memberId);
		} else {
			model.addAttribute("message", "[로그인 실패] 로그인 정보를 다시 확인하세요.");
		}
		
		return "result";
	}
	
//	@RequestMapping("/login")
//	public void login(Member dto) {
//		System.out.println("로그인요청");
//		System.out.println(dto.getMemberId() + ", " + dto.getMemberPw());
//		
//	}
	
//	@RequestMapping("/member/size")
//	@ResponseBody
//	public int size() {
//		return memberservice.getSize();
//	}
	
//	@RequestMapping(value = "/member/size", method = RequestMethod.POST)
//	@ResponseBody
//	public int size() {
//		return memberservice.getSize();
//	}
	
	//@PostMapping("/member/size")
	@GetMapping("/member/size")
	@ResponseBody
	public int size() {
		return memberService.getSize();
	}
	
}
