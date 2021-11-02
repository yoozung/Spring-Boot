package com.work.wecamp.camplike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.work.wecamp.camp.dto.Campsite;
import com.work.wecamp.camplike.dto.CamplikeDto;
import com.work.wecamp.camplike.service.CamplikeService;
import com.work.wecamp.member.config.auth.PrincipalDetails;
import com.work.wecamp.member.model.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CamplikeController<Campsite> {
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
		return "inc/camp-search-list";
		
	}
	
	/**
	 * 좋아요 삭제
	 * @param model
	 * @param dto
	 * @param principalDetails
	 * @return
	 */
	@GetMapping("/dislike")
	public String dislike(Model model, CamplikeDto dto,  @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Member mdto = principalDetails.getMember();
		model.addAttribute("dto", dto);
		int member_no = mdto.getMember_no();
		String campsite_no = dto.getCampsiteNo();
		camplikeService.dislike(campsite_no, member_no);
		return "inc/camp-search-list";
		
	}
	
	/**
	 * 내가 좋아요 누른 캠핑장 조회
	 * @param principalDetails
	 * @return
	 */
	@GetMapping("/mylike")
	public String mylike(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Member mdto = principalDetails.getMember();
		int member_no = mdto.getMember_no();
		List<com.work.wecamp.camp.dto.Campsite> campList = camplikeService.mylike(member_no);
		model.addAttribute("campList", campList);
		return "member/mylike-list";
		
	}
	
	
	
}
