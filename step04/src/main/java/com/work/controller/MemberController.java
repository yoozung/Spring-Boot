package com.work.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.dto.Member;
import com.work.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	public MemberService memberService;
	
	@RequestMapping("/main")
	public String main() {
		return "main"; 
	}
	
	@RequestMapping("/joinForm")
	public String joinForm(HttpSession session, Model model) {
		
		return "joinForm";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm(HttpSession session, Model model) {
		
		return "loginForm";
	}

//	@RequestMapping("/selectMemberList")
//	public List<Member> selectMemberList() {
//		System.out.println("@@회원조회요청");
//		System.out.println();
//		List<Member> list = memberService.memberList();
//		System.out.println(list);
//		if (list == null) {
//			
//		}
//		return list;
//	}

	
	@RequestMapping("/join")
	public String join(Member dto, Model model) {
		//System.out.println("회원가입요청"); // 개발중에 디버그 정보 출력, 개발완료후에는 삭제해야함..
		//System.out.println(dto);
		log.info("### 회원가입요청");
		log.debug("### " + dto);
		
		int result = memberService.addMember(dto);
		if (result ==1) {
			// 회원가입 성공
			model.addAttribute("message", "[회원가입성공] 로그인 후 서비스 이용하세요");
			return "loginForm";
		} else {
			// 회원가입 실패 
			model.addAttribute("message", "[회원가입실패] 가입 정보를 다시 확인하세요");
			return "result";
		}

	}
	
	@RequestMapping("/login")
	public String login(String memberId, String memberPw, Model model, HttpSession session) {
		log.debug("###" + session.isNew() + ", " + session.getCreationTime());
		
		log.info("### 로그인요청");
		log.debug("### " + memberId + ", " + memberPw);

		String grade = memberService.login(memberId, memberPw);
		
		Member dto = memberService.loginToMember(memberId, memberPw);
		
		System.out.println("login grade : " + grade);
	
		if (grade != null && dto != null) {
			session.setAttribute("memberId", memberId);
			session.setAttribute("grade", grade);

			session.setAttribute("dto", dto);
			
			model.addAttribute("message", "[로그인 사용자]" + memberId);
			return "main";
		} else {
			model.addAttribute("message", "[로그인 실패] 로그인 정보를 다시 확인하세요.");
			return "result";
		}
	}
	
	@RequestMapping("/memberList")
	public String memberList(Model model, HttpSession session) {
		List<Member> list = memberService.memberList();
		model.addAttribute("list", list);
		return "memberList";
	}
	
//	
//	@RequestMapping("/memberDetail")
//	public String memberDetail(String memberId, Model model) {
//		Member dto = memberService.memberDetail(memberId);
//		model.addAttribute("dto", dto);
//		return "memberDetail";
//	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 세션객체 가져와서(DI) 세션설정 정보 삭제하고 세션객체 삭제처리
		Enumeration<String> attributes = session.getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = attributes.nextElement();
			log.debug("###" + attribute + ":" + session.getAttribute(attribute));
			session.removeAttribute(attribute);
		}
		session.invalidate();
		return "main";
	}
	
	
}
