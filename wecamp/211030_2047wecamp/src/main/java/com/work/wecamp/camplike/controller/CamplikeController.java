package com.work.wecamp.camplike.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.work.wecamp.camplike.dto.CamplikeDto;
import com.work.wecamp.camplike.service.CamplikeService;
import com.work.wecamp.member.config.auth.PrincipalDetails;
import com.work.wecamp.member.model.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CamplikeController {
	@Autowired
	private CamplikeService camplikeService;
	
//	@GetMapping("/like")
//	public String like(Model model, CamplikeDto dto,   @AuthenticationPrincipal PrincipalDetails principalDetails) {
//		Member dto = principalDetails.getMember();
//		model.addAttribute("dto", dto);
//		int member_no = dto.getMember_no();
//		camplikeService.like(dto, member_no);
//		
//		return null;
//		
//	}
}
