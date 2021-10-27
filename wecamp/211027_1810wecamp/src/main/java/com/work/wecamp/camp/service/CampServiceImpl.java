package com.work.wecamp.camp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.wecamp.camp.dao.CampDao;
import com.work.wecamp.camp.dto.Campsite;
import com.work.wecamp.util.TestApiUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CampServiceImpl implements CampService {
	
	@Autowired
	private CampDao campDao;
	
	@Override
	public int insertCampsite() {
		
		int insertResult = 0;
		int result = 0;
		
		/*api 데이터 받아오기 */
		List<Campsite> campList = TestApiUtil.getCampList();
		
		for(int i=0; i < campList.size(); i++) {
			insertResult = campDao.insertCampsite(campList.get(i));
			
			if(insertResult != 1) {
				System.out.println("오류오류");
				result = 1;
				break;
			}
		}
		return result;
	}

	@Override
	public List<Map<String,String>> selectDoNm() {
		List<Map<String,String>> doNm = campDao.selectDoNm();
		return doNm;
	}

	@Override
	public List<Map<String, String>> selectSigungu(String doNm) {
		List<Map<String,String>> sigungu = campDao.selectSigungu(doNm);
		return sigungu;
	}

	@Override
	public List<Map<String, Campsite>> selectDoSiCampsite(Map<String, String> doSi) {
		List<Map<String,Campsite>> campsite = campDao.selectDoSiCampsite(doSi);
		return campsite;
	}
	

	@Override
	public int doSiTotalCount(String sigungu) {
		return campDao.doSiTotalCount(sigungu);
	}

	@Override
	public int totalCount() {
		return campDao.totalCount();
	}

	@Override
	public List<Map<String, Campsite>> selectCampsiteAll(int startCount,int endCount) {
		return campDao.selectCampsiteAll(startCount,endCount);
	}

	@Override
	public Campsite selectOne(int campsiteNo) {
		return campDao.selectOne(campsiteNo);
	}
	
	/*------------------------------------------------------------------------------*/
	
	
	
	
	
}
