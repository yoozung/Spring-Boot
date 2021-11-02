package com.work.wecamp.review.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.work.wecamp.member.config.auth.PrincipalDetails;
import com.work.wecamp.member.model.Member;
import com.work.wecamp.review.dto.ReviewDto;
import com.work.wecamp.review.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	
	/** 상세조회 페이지 이동 */
	@GetMapping("/review/detail")
	public String detail() {
		return "/review/campDetail";
	}
	
	/** 리뷰등록페이지로 이동 */
	@GetMapping("/review")
	public String write(@RequestParam(value="no") String campsite_no,  Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		model.addAttribute("no", campsite_no);
		Member dto = principalDetails.getMember();
		model.addAttribute("dto", dto);
		return "/review/reviewWrite";
	}
	
	/** 리뷰등록 */
	@GetMapping("/reviewWrite")
	public String write(ReviewDto dto, Model model) {
		int result = reviewService.insertReview(dto);
		if (result == 1) {
			model.addAttribute("message", "[리뷰 등록 성공]");
			return "/review/writeResult";
		} else {
			model.addAttribute("message", "[등록 실패]");
			return "/";
		}
	}
	
	/** 리뷰조회 */
	@GetMapping("/reviewList")
	public String list(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		Member dto = principalDetails.getMember();
		int member_no = dto.getMember_no();
		List<ReviewDto> list = reviewService.r(member_no);
		model.addAttribute("list", list);
		return "/review/reviewList";
	}
	
	/** 리뷰상세 */
	@GetMapping("/reviewDetail")
	public String detail(Model model,  String reviewNo) {
		ReviewDto dto = reviewService.reviewDetail(reviewNo);
		model.addAttribute("dto", dto);
		return "review/reviewDetail";
	}
	
	/** 리뷰 수정 */
	@GetMapping("/reviewUpdate")
	public String update(ReviewDto dto, String reviewNo) {
		reviewService.updateReview(dto, reviewNo);
		return "review/writeResult";
	}
	
	
	/** 리뷰 삭제 */
	@RequestMapping("/reviewDelete")
	public String delete(String reviewNo) {
		reviewService.deleteReview(reviewNo);
		return "/review/reviewList";
	}
	
}
