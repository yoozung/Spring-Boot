package com.work.wecamp.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.work.wecamp.review.dao.ReviewDao;
import com.work.wecamp.review.dto.ReviewDto;
import com.work.wecamp.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Repository
@Service
@Slf4j
public class ReviewService implements ReviewDao {
	@Autowired
	private ReviewDao reviewDao;

	/** 리뷰등록 */
	@Override
	public int insertReview(ReviewDto dto) {
		//dto.setCampsite_no("7969");
		dto.setMemberNo("1");
		dto.setStarRating((dto.getEnvRating() + dto.getFclRating() + dto.getServiceRating())/3);
		dto.setCreateDate(Utility.getCurrentDate());
		
		System.out.println(dto.getStarRating());
		
		int result = reviewDao.insertReview(dto);
		log.debug("dao result:" + result);
		return result;
	}

	/** 캠핑장별 리뷰조회 */
	public List<ReviewDto> reviewList(int campsiteNo) {
		return reviewDao.reviewList(campsiteNo);
	}
	
	/** 리뷰조회 */
	public List<ReviewDto> r() {
		return reviewDao.r();
	}


	
	/** 리뷰상세 */
	public ReviewDto reviewDetail(String reviewNo) {
		System.out.println("서비스리뷰번호 : " + reviewNo);
		return reviewDao.reviewDetail(reviewNo);
	}

	
	/** 리뷰수정 */
	public int updateReview(ReviewDto dto, String reviewNo) {
		dto.setStarRating((dto.getEnvRating() + dto.getFclRating() + dto.getServiceRating())/3);
		reviewDao.updateReview(dto, reviewNo);
		return 0;
	}

	/** 리뷰삭제 */
	public void deleteReview(String reviewNo) {
		reviewDao.deleteReview(reviewNo);
		System.out.println("삽;ㅅ,ㅇ[사 후기번호확인" + reviewNo);
	}

	



}
