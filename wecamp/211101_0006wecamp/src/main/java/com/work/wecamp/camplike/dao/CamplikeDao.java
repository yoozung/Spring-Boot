package com.work.wecamp.camplike.dao;

 

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.work.wecamp.camp.dto.Campsite;
import com.work.wecamp.camplike.dto.CamplikeDto;
 

@Mapper
public interface CamplikeDao {

	@Select("select * from camplike where member_no =#{member_no} and campsite_no = #{campsiteNo}")
	public List<CamplikeDto> getlike(int member_no, int campsiteNo);

	/**
	 * 좋아요 누르기
	 * @param dto
	 * @param member_no
	 */
	@Insert("insert into camplike values(#{campsiteNo}, #{memberNo})")
	public void like(CamplikeDto dto);
 
	/**
	 * 좋아요 빼기
	 * @param dto
	 * @param member_no
	 */
	@Delete("delete from camplike where member_no = #{member_no} and campsite_no = #{campsite_no}")
	public void dislike(String campsite_no, int member_no);


	/*캠핑장 좋아요 수 세기*/
	@Select("SELECT COUNT(*) FROM camplike WHERE campsite_no = #{campsiteNo}")
	public int likesize(int campsiteNo);

	// 내가 누른 좋아요
	@Select("select * from campsite where member_no = #{member_no}")
	public List<Campsite> mylike(int member_no);

	
	
	 

}
