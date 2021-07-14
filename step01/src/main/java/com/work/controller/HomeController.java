package com.work.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.dto.Member;

@Controller
public class HomeController {
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "시작화면";
	}
	
	@RequestMapping("/array")
	@ResponseBody
	public int[] showArray() {
		//return new int[] {10, 20, 30};
		int[] nos = new int[5];
		for (int index=0, init=10; index < 3; index++, init +=10) {
			nos[index] = init;
		}
		return nos;		// JSON : [10, 20, 30]
	}
	
	@RequestMapping("/member")
	@ResponseBody
	public Member showMember() {
		Member dto = new Member("user01", "password01", "홍길동", "010-2134-1234", "user01@work.com", "2017-07-14", "G", 7000, null);
		System.out.println(dto);
		// {"memberId":"user01","memberPw":"password01","name":"홍길동","mobile":"010-2134-1234","email":"user01@work.com","entryDate":"2017-07-14","grade":"G","mileage":7000,"manager":null}
		
		return dto;
		// JSON : {"memberId":"user01","memberPw":"password01","name":"홍길동","mobile":"010-2134-1234","email":"user01@work.com","entryDate":"2017-07-14","grade":"G","mileage":7000,"manager":null}
	}
	
	@RequestMapping("/member2")
	@ResponseBody
	public Member showMember2() {
		//Member dto = new Member("user01", "memberPw", "강감");
		//Member dto = new Member("강감", "user01", "memberPw", "010-1234-1234");
		// 일부 데이터 지정 객체 생성 
		// 순서도 임의로 지정해서 생성
		// @Builder(Builder pattern) 빌더는 전체데이터초기화생성자가 있는 상태에서 사용할 수 있음
		// Builder를 이용항 객체 생성 방법 : 클래스명.builder().프로퍼티명(data).프로퍼티명(data).build();
		
		return Member.builder().memberId("bluesky").mobile("010-1234-1234").
				name("홍길동").build();
	}
	
	@RequestMapping("/list")
	@ResponseBody	
	public List<String> showList() {
		
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("안녕");
		return list;	// JSON Array : ["hello", "안녕"]
	}
	
	@RequestMapping("/map")
	@ResponseBody	
	public Map<String, Object> showMap() {
		Member dto1 = Member.builder().memberId("user01").name("홍").mobile("010-1515-1515").grade("G").build();
		Member dto2 = Member.builder().memberId("user02").name("길").mobile("010-1515-1515").grade("S").build();
		Member dto3 = Member.builder().memberId("user03").name("오").mobile("010-1515-1515").grade("A").build();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put(dto1.getMemberId(), dto1);
		map1.put(dto2.getMemberId(), dto2);
		map1.put(dto3.getMemberId(), dto3);
		
		Map<String, Object> map2 = new LinkedHashMap<String, Object>();
		map2.put(dto1.getMemberId(), dto1); 
		map2.put(dto2.getMemberId(), dto2); 
		map2.put(dto3.getMemberId(), dto3); 
		
		// 반환타입이 interface 이어서 유연한 어플리케이션 : Map을 구현한 모든 Map 클래스 사용 가능함 
		//return map1;	// HashMap : 순서 보장하지 않음
		return map2;	// LinkedHashMap : 순서 보장
	}
	
}
