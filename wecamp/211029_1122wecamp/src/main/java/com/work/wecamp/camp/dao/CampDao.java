package com.work.wecamp.camp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.work.wecamp.camp.dto.Campsite;

@Mapper
@Repository
public interface CampDao {
	/*캠핑장 데이터 추가*/
	public int insertCampsite(Campsite campsite);

	/*도 데이터 조회*/
	@Select("SELECT do_nm,TO_CHAR(COUNT(do_nm)) do_count FROM campsite GROUP BY do_nm")
	public List<Map<String,String>> selectDoNm();
	
	/*시군구 데이터 조회*/
	public List<Map<String,String>> selectSigungu(String doNm);
	
	/*도, 시군구에 맞는 캠핑장 조회*/
	//@Select("SELECT * FROM campsite WHERE do_nm=#{doNm} AND sigungu=#{sigungu}")
	public List<Map<String,Campsite>> selectDoSiCampsite(Map<String, String> doSi);
	
	/*시군구 캠핑장 데이터 수 조회*/
	@Select("SELECT count(campsite_no) FROM campsite WHERE sigungu=#{sigungu}")
	public int doSiTotalCount(String sigungu);
	
	/*캠핑장 총 데이터 수 조회*/
	public int totalCount();

	/*캠핑장 데이터 페이징 처리 및 조회*/
	public List<Map<String, Campsite>> selectCampsiteAll(int startCount, int endCount);

	/*캠핑장 상세조회*/
	@Select("SELECT * FROM campsite WHERE campsite_no=#{campsiteNo}")
	public Campsite selectOne(int campsiteNo);
}
