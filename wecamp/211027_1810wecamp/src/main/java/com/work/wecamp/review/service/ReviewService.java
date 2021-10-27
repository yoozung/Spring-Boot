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
		dto.setCampsite_no("7969");
		dto.setMember_no("1");
		dto.setStar_rating((dto.getEnv_rating() + dto.getFcl_rating() + dto.getService_rating())/3);
		dto.setCreate_date(Utility.getCurrentDate());
		
		System.out.println(dto.getStar_rating());
		
		int result = reviewDao.insertReview(dto);
		log.debug("dao result:" + result);
		return result;
	}

	/** 리뷰조회 */
	public List<ReviewDto> reviewList() {
		return reviewDao.reviewList();
	}

	/** 리뷰상세 */
	public ReviewDto reviewDetail(String review_no) {
		System.out.println("서비스리뷰번호 : " + review_no);
		return reviewDao.reviewDetail(review_no);
	}

	
	/** 리뷰수정 */
	public int updateReview(ReviewDto dto) {
		dto.setStar_rating((dto.getEnv_rating() + dto.getFcl_rating() + dto.getService_rating())/3);
		reviewDao.updateReview(dto);
		return 0;
	}

	/** 리뷰삭제 */
	public void deleteReview(String review_no) {
		reviewDao.deleteReview(review_no);
		System.out.println("삽;ㅅ,ㅇ[사 후기번호확인" + review_no);
	}

	



}
