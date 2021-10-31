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
	
	/**
	 * 좋아요 누르기
	 * @param model
	 * @param dto
	 * @param principalDetails
	 * @return
	 */
	@GetMapping("/like")
	public String like(Model model, CamplikeDto dto,  @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		camplikeService.like(dto);
		
		return "campsite/campsite-detail";
		
	}
	
	
	@GetMapping("/dislike")
	public String dislike(Model model, CamplikeDto dto,  @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Member mdto = principalDetails.getMember();
		model.addAttribute("dto", dto);
		int member_no = mdto.getMember_no();
		String campsite_no = dto.getCampsiteNo();
		camplikeService.dislike(campsite_no, member_no);
		
		return "campsite/campsite-detail";
		
	}
	
	
}
