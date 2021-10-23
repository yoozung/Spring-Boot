package com.work.wecamp.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.work.wecamp.review.dto.ReviewDto;

@Mapper
public interface ReviewDao {
	
	/** 리뷰 등록 */
	@Insert("insert into review values(review_no.nextval, #{campsite_no}, #{member_no}, #{content}, #{create_date}, #{star_rating}, #{fcl_rating}, #{env_rating}, #{service_rating})")
	public int insertReview(ReviewDto dto);

	/** 리뷰조회 */
	@Select("SELECT * FROM review")
	public List<ReviewDto> reviewList();

	/** 리뷰상세 */
	@Select("SELECT * FROM review WHERE review_no=#{review_no}")
	public ReviewDto reviewDetail(String review_no);
	
	/** 리뷰수정 */
	@Update("UPDATE review SET content = #{content}, fcl_rating = #{fcl_rating}, star_rating = #{star_rating}, env_rating = #{env_rating},  service_rating = #{service_rating} WHERE review_no = #{review_no}")
	public int updateReview(ReviewDto dto);

	/** 리뷰삭제 */
	@Delete("DELETE FROM review WHERE review_no=#{review_no}")
	public void deleteReview(String review_no);

	

}
