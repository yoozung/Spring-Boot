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
	
	private String reviewNo;
	private String campsiteNo;
	private String memberNo;
	private String content;
	private String createDate;
	private String username;
	private Double starRating;
	private Double fclRating;
	private Double envRating;
	private Double serviceRating;
	
}
