package com.work.wecamp.camplike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.work.wecamp.camp.dto.Campsite;
import com.work.wecamp.camplike.dao.CamplikeDao;
import com.work.wecamp.camplike.dto.CamplikeDto;
 
import com.work.wecamp.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Repository
@Service
@Slf4j
public class CamplikeService implements CamplikeDao {
	@Autowired
	private  CamplikeDao camplikeDao;

	/* 캠핑장 상세조회시 좋아요 정보 불러오기*/
	public List<CamplikeDto> getlike(int member_no, int campsiteNo) {
		return camplikeDao.getlike(member_no, campsiteNo);
	}

	/*  좋아요 누르기 */
	public void like(CamplikeDto dto) {
		  camplikeDao.like(dto);
		
	}


	/* 좋아요 뺴기*/
	public void dislike(String campsite_no, int member_no) {
		  camplikeDao.dislike(campsite_no, member_no);
		
	}

	
	/* 캠핑장별 좋아요수 가져오기 */
	public int likesize(int campsiteNo) {
		return camplikeDao.likesize(campsiteNo);
	}

	/* 내가 좋아요 누른 캠핑장 조회 */
	public List<Campsite> mylike(int member_no) {
		return camplikeDao.mylike(member_no);
	}



	
	 
 

	 
	 
	
	



}
