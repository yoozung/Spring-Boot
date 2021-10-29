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
	@Insert("insert into review values(review_no.nextval, #{campsiteNo}, #{memberNo}, #{content}, #{createDate}, #{starRating}, #{fclRating}, #{envRating}, #{serviceRating})")
	public int insertReview(ReviewDto dto);

	/** 캠핑장별 리뷰조회 */
	@Select("SELECT * FROM review where campsite_no=#{campsiteNo}")
	public List<ReviewDto> reviewList(int campsiteNo);
	
	
	/** 리뷰조회 */
	@Select("SELECT * FROM review")
	public List<ReviewDto> r();

	/** 리뷰상세 */
	@Select("SELECT * FROM review WHERE review_no=#{reviewNo}")
	public ReviewDto reviewDetail(String reviewNo);
	
	/** 리뷰수정 */
	@Update("UPDATE review SET content = #{content}, fcl_rating = #{fclRating}, star_rating = #{starRating}, env_rating = #{envRating}, service_rating = #{serviceRating} WHERE review_no = #{reviewNo}")
	public int updateReview(ReviewDto dto, String reviewNo);

	/** 리뷰삭제 */
	@Delete("DELETE FROM review WHERE review_no=#{reviewNo}")
	public void deleteReview(String reviewNo);


}
