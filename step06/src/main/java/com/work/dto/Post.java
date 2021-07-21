package com.work.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/** 
 * 게시판 도메인 클래스 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
	private String title;
	private String name;
	private String writeDate;
}
