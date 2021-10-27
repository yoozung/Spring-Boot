package com.work.wecamp.camp.service;

import java.util.List;
import java.util.Map;

import com.work.wecamp.camp.dto.Campsite;

public interface CampService {
	
	/*캠핑장 데이터 삽입*/
	public int insertCampsite();
	
	/*도 데이터 조회*/
	public List<Map<String,String>> selectDoNm();
	
	/*시군구 데이터 조회*/
	public List<Map<String,String>> selectSigungu(String doNm);
	
	/*도, 시군구로 캠핑장 조회*/
	public List<Map<String,Campsite>> selectDoSiCampsite(Map<String,String> doSi);

	/*시군구 캠핑장 데이터 수*/
	public int doSiTotalCount(String sigungu);
	
	/*캠핑장 총 데이터 수 */
	public int totalCount();
	
	/*캠핑장 전체 데이터 페이징 처리 */
	public List<Map<String,Campsite>> selectCampsiteAll(int startCount, int endCount);

	/*캠핑장 상세 조회 */
	public Campsite selectOne(int campsiteNo);



}
