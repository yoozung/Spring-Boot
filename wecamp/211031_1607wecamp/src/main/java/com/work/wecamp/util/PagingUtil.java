package com.work.wecamp.util;

import java.util.HashMap;

public class PagingUtil {
	public static HashMap<String,Integer> ready(String pageNo,int totalCount){
		HashMap<String, Integer> countMap = new HashMap<String,Integer>();
		
		/* 파라미터로 받아옴 */
		/* 현재 페이지 */
		int page = Integer.parseInt(pageNo);

		
		// 한 페이지에 출력될 게시물 수
		int countList = 15;
		
		// 화면에 출력될 페이지 수 
		int countPage = 10;
		
		// 쿼리문 rownum 시작, 끝
		int startCount = (page - 1) * countList + 1;
		int endCount = page * countList;
		
		
		// +1을 해주는 이유는 페이지가 countPage보다 낮을때 0으로 떨어지기 때문임 
		int startPage = ((page-1) / countPage) * countPage + 1;
		
		// startPage가 1,11,21로 시작하기 때문에 -1 을 빼서 딱 떨어지게 한다. 
		int endPage = startPage + countPage - 1;
		
		// 전체 페이지 수 
		int totalPage = totalCount / countList;
		
		// 총 갯수 / 출력될 게시물 수 = 나머지가 있으면 총 페이지 하나 추가 
		if(totalCount % countList > 0) {
			totalPage++;
		}
		
		// 현재 페이지가 총 페이지보다 크다면 총 페이지로 치환시킨다.  
		if(page > totalPage) {
			page = totalPage;
		}
		
		// 마지막 페이지가 총 페이지 보다 크면 치환 
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		countMap.put("startPage",startPage);
		countMap.put("page",page);
		countMap.put("endPage",endPage);
		countMap.put("totalPage",totalPage);
		countMap.put("startCount",startCount);
		countMap.put("endCount",endCount);
		
		
		return countMap;
	}
}
