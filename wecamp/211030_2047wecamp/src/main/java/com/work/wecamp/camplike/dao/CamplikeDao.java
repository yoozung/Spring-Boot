package com.work.wecamp.camplike.dao;

 

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.work.wecamp.camplike.dto.CamplikeDto;
 

@Mapper
public interface CamplikeDao {

	@Select("select * from camplike where member_no =#{member_no} and campsite_no = #{campsiteNo}")
	public List<CamplikeDto> getlike(int member_no, int campsiteNo);

	//UPDATE camplike SET like_yn = 1 WHERE member_no=3;
	@Update("update camplike SET like_yn = 1 where member_no = #{member_no}")
	public void like(CamplikeDto dto, int member_no);
 

	 

}
