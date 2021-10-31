package com.work.wecamp.camp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author 이택근
 * campsiteNo : 캠핑장 번호
 * facltNm : 캠핑장 이름 
 * lineIntro : 한줄 소개 
 * detailIntro : 소개
 * induty : 업종 
 * lctCl : 입지구분 
 * doNm : 도이름 
 * sigungu : 시군구 이름
 * zipcode : 우편번호
 * addr1 : 주소 
 * addr2 : 상세주소
 * lon : 경도 
 * lat : 위도 
 * tel : 전화번호 
 * homepage : 홈페이지 
 * resveUrl : 예약페이지
 * glampInner : 글램핑 내부시설 
 * caravanInner : 카라반 내부시설 
 * operationP : 운영기간 
 * operationD : 운영일 
 * trlerYn : 개인트레일러 동반여부
 * caravYn : 개인 카라반 동반여부
 * sbrsCl : 부대시설 
 * sbrsEtc : 부대시설 기타
 * posblFcl : 주변이용가능시설
 * themaEnv : 테마환경 
 * animalCmg : 애완동물출입여부
 * thumbnail : 대표이미지
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campsite {
	private String campsiteNo;
	private String facltNm;
	private String lineIntro;
	private String detailIntro;
	private String induty;
	private String lctCl;
	private String doNm;
	private String sigungu;
	private String zipcode;
	private String addr1;
	private String addr2;
	private Double lon;
	private Double lat;
	private String tel;
	private String homepage;
	private String resveUrl;
	private String glampInner;
	private String caravanInner;
	private String operationP;
	private String operationD;
	private String trlerYn;
	private String caravYn;
	private String sbrsCl;
	private String sbrsEtc;
	private String posblFcl;
	private String themaEnv;
	private String animalCmg;
	private String thumbnail;
	
}
