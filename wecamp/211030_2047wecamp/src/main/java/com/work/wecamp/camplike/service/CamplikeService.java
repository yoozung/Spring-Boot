package com.work.wecamp.camplike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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

	public List<CamplikeDto> getlike(int member_no, int campsiteNo) {
		return camplikeDao.getlike(member_no, campsiteNo);
	}

	public void like(CamplikeDto dto, int member_no) {
		  camplikeDao.like(dto, member_no);
		
	}

 
	 
	
	



}
