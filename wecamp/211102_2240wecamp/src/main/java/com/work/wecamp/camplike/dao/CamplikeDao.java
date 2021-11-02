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

	/** 캠핑장별로 내가 좋아요 눌렀는지 확인 */
	@Select("select * from camplike where member_no =#{member_no} and campsite_no = #{campsiteNo}")
	public List<CamplikeDto> getlike(int member_no, int campsiteNo);

	/** 좋아요 누르기 */
	@Insert("insert into camplike values(#{campsiteNo}, #{memberNo})")
	public void like(CamplikeDto dto);
 
	/** 좋아요 빼기 */
	@Delete("delete from camplike where member_no = #{member_no} and campsite_no = #{campsite_no}")
	public void dislike(String campsite_no, int member_no);

	/** 캠핑장별 좋아요 수 세기 */
	@Select("SELECT COUNT(*) FROM camplike WHERE campsite_no = #{campsiteNo}")
	public int likesize(int campsiteNo);

	/** 내가 좋아요 누른 캠핑장 조회 */
	@Select("select * from camplike a, campsite b where a.campsite_no = b.campsite_no and a.member_no = #{member_no}")
	public List<Campsite> mylike(int member_no);

	
	
	 

}
