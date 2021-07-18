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
		// 로그인하지 않은 사용자 제공
		// 로그인한 사용자가 요청하면 "로그인 사용자가 이용할 수 없는 서비스입니다"
		if (session.getAttribute("memberId") != null && session.getAttribute("dto") != null) {
			model.addAttribute("message", "로그인 사용자가 이용할 수 없는 서비스입니다");
			return "main";
		}
		return "joinForm";
	}

	@RequestMapping("/loginForm")
	public String loginForm(HttpSession session, Model model) {
		// 로그인하지 않은 사용자 제공
		return "loginForm";
	}

	@RequestMapping("/join")
	public String join(Member dto, Model model) {
		// System.out.println("회원가입요청"); // 개발중에 디버그 정보 출력, 개발완료후에는 삭제해야함..
		// System.out.println(dto);
		log.info("### 회원가입요청");
		log.debug("### " + dto);

		int result = memberService.addMember(dto);
		if (result == 1) {
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
		// HttpSession session = request.getSession(); //true
		log.debug("###" + session.isNew() + ", " + session.getCreationTime());

		log.info("### 로그인요청");
		log.debug("### " + memberId + ", " + memberPw);

		// 로그인 회원의 등급 반환
		String grade = memberService.login(memberId, memberPw);

		// 로그인 회원의 도메인 반환
		Member dto = memberService.loginToMember(memberId, memberPw);

		System.out.println("login grade : " + grade);

		if (grade != null && dto != null) {
			// 사용자 인증처리

			// session.invalidate();
			// 혹시라도 기존세션에 있는 세션정보가 존재할 수도 있으니 기존 세션객체 삭제 이유 : 세션설정 정보 삭제하기 위함
			// 다시 새로운 세션객체를 생성 => request.getSession();
			// getAttributeNames():java.util.Ennumeration
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
		// 요청에 대한 사용자 인증 및 권한 체킹 부분이 누락
		//
		// 인증여부 체크
		if (session.getAttribute("memberId") == null || session.getAttribute("dto") == null) {
			model.addAttribute("message", "로그인 인증 후 이용하시기 바랍니다.");
			return "result";
		}

		// 관리자 권한 여부 체크
		if (!session.getAttribute("grade").equals("A")
				|| !((Member) session.getAttribute("dto")).getGrade().equals("A")) {
			model.addAttribute("message", "관리자 권한 획득 후 이용하시기 바랍니다.");
			return "main";
		}

		List<Member> list = memberService.memberList();
		model.addAttribute("list", list);
		return "memberList";
	}

	@RequestMapping("/memberDetail")
	public String memberDetail(String memberId, Model model) {
		Member dto = memberService.memberDetail(memberId);
		model.addAttribute("dto", dto);
		return "memberDetail";
	}

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
