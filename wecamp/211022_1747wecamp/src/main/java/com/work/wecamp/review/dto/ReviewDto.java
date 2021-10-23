package com.work.wecamp.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewDto {
	
	private String review_no;
	private String campsite_no;
	private String member_no;
	private String content;
	private String create_date;
	private double star_rating;
	private double fcl_rating;
	private double env_rating;
	private double service_rating;
	
}
