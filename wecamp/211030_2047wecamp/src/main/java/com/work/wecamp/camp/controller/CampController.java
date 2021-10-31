package com.work.wecamp.camp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.work.wecamp.camp.dto.Campsite;
import com.work.wecamp.camp.service.CampService;
import com.work.wecamp.camplike.dto.CamplikeDto;
import com.work.wecamp.camplike.service.CamplikeService;
import com.work.wecamp.member.config.auth.PrincipalDetails;
import com.work.wecamp.member.model.Member;
import com.work.wecamp.review.dto.ReviewDto;
import com.work.wecamp.review.service.ReviewService;
import com.work.wecamp.util.PagingUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/camp")
public class CampController {
	@Autowired
	CampService campService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private CamplikeService camplikeService;
	
	/*데이터 삽입*/
	@GetMapping("/request")
	public String requestApi(Model model,Campsite campsite) {
		
		int result = campService.insertCampsite();
		model.addAttribute("insertResult",result);
		
		return "/index";
	}
	
	/* 캠핑장 검색 첫 페이지 */
	@GetMapping("/camplist")
	public String getCampList() {
		return "campsite/camp-search";
	}
	
	/*도 이름 출력*/
	//조각페이지
	@PostMapping("/donm")
	public String getDoNm(Model model) {
		log.debug("enter getdoNm");
		
		List<Map<String,String>> doNmList = campService.selectDoNm();
		model.addAttribute("doNms",doNmList);
		
		return "inc/camp-donm";
	}
	
	/*시군구 이름 출력*/
	@PostMapping("/sigungu")
	public String getSigungu(@RequestParam String doNm,Model model) {
	
		log.debug("enter getSigungu");
		
		List<Map<String,String>> sigunguList = campService.selectSigungu(doNm);
		model.addAttribute("sigungu",sigunguList);
		
		return "inc/camp-sigungu";
	}
	/*지역 캠핑장 검색*/
	@PostMapping("/search/ds")
	public String getDoSiCampsite(@RequestBody Map<String,String> doSi,Model model){
		log.debug("enter getDosi");
		
		/*시군구로 데이터 수 조호회*/
		int doSitotalCount = campService.doSiTotalCount(doSi.get("sigungu"));
		HashMap<String, Integer> pagingMap = 
					PagingUtil.ready(getCampList(), doSitotalCount);
		
		
		List<Map<String,Campsite>> doSiList = campService.selectDoSiCampsite(doSi);
		model.addAttribute("campList",doSiList);
		
		return "inc/camp-search-list";
	}
	
	
	/* 캠핑장 모든 데이터 출력*/
	@PostMapping("/all")
	public String getCampsiteAll(@RequestParam String pageNo,Model model){
		log.debug("enter All Select");
		
		// 캠핑장 총 갯수
		/* DB에서 받아옴*/
		int totalCount = campService.totalCount();
		HashMap<String,Integer> pagingMap = 
					PagingUtil.ready(pageNo,totalCount);
		
		List<Map<String, Campsite>> campList = 
				campService
					.selectCampsiteAll 
					(pagingMap.get("startCount"),pagingMap.get("endCount"));
		
		model.addAttribute("campList",campList);
		model.addAttribute("paging",pagingMap);

		
		return "inc/camp-search-list";
	}
/*-------------------------------------------------------------------------------*/

	
	/* 캠핑장 상세조회 */
	@GetMapping("/detail")
	public String deatilCampsite(@RequestParam int campsiteNo, Model model,  @AuthenticationPrincipal PrincipalDetails principalDetails) {
		log.debug("enter deatil Campsite");
		
		// 캠핑장 정보 가져오기
		Campsite campsite = campService.selectOne(campsiteNo);
		System.out.println("출력 : " + campsite.toString());
		model.addAttribute("campsite",campsite);
		
		// 회원 가져오기
		if(principalDetails != null) {
		Member dto = principalDetails.getMember();
		model.addAttribute("dto", dto);
		int member_no = dto.getMember_no();
		System.out.println("@@@@@@좋아요기능 회원번호" + member_no);
		
		// 좋아요 가져오기
		String str = Integer.toString(member_no);
		System.out.println("※※※※※※※※※※※회원번호를 문자열로" + str);
		if (str !=  null) {
			List<CamplikeDto> like = camplikeService.getlike(member_no, campsiteNo);
			model.addAttribute("like", like);
			System.out.println(" ##### 좋아요 담아오기  " + like);
		} 
			return "campsite/campsite-detail";
		
		}
		
		// 리뷰 가져오기
		List<ReviewDto> list = reviewService.reviewList(campsiteNo);
		model.addAttribute("list", list);
		

		
		
		
		return "campsite/campsite-detail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
