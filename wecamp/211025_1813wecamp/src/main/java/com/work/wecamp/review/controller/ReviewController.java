package com.work.wecamp.review.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.work.wecamp.review.dto.ReviewDto;
import com.work.wecamp.review.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	
	/** 상세조회 페이지 이동 */
	@GetMapping("/")
	public String detail() {
		return "/review/detail";
	}
	
	/** 리뷰등록페이지로 이동 */
	@GetMapping("/review")
	public String write() {
		return "/review/reviewWrite";
	}
	
	/** 리뷰등록 */
	@GetMapping("/reviewWrite")
	public String write(ReviewDto dto, Model model) {
//		System.out.println("컨트롤러진입");
		int result = reviewService.insertReview(dto);
		if (result == 1) {
			model.addAttribute("message", "[리뷰 등록 성공]");
			return "/review/writeResult";
		} else {
			model.addAttribute("message", "[등록 실패]");
			return "result";
		}
	}
	
	/** 리뷰조회 */
	@GetMapping("/reviewList")
	public String list(Model model) {
		List<ReviewDto> list = reviewService.reviewList();
		model.addAttribute("list", list);
		return "/review/reviewList";
	}
	
	/** 리뷰상세 */
	@GetMapping("/reviewDetail")
	public String detail(Model model, String review_no) {
		System.out.println("리뷰번호 : " + review_no);
		ReviewDto dto = reviewService.reviewDetail(review_no);
		model.addAttribute("dto", dto);
		System.out.println(dto);
		return "review/reviewDetail";
	}
	
	/** 리뷰 수정 */
	@GetMapping("/reviewUpdate")
	public String update(ReviewDto dto) {
		
		reviewService.updateReview(dto);
		return "/review/reviewList";
	}
	
	
	/** 리뷰 삭제 */
	@RequestMapping("/reviewDelete")
	public String delete(String review_no) {
		System.out.println("컨트롤러진입");
		System.out.println("후기번호" + review_no);
		reviewService.deleteReview(review_no);
		System.out.println("서비스넘어감");
		return "/review/reviewList";
	}
	
}
