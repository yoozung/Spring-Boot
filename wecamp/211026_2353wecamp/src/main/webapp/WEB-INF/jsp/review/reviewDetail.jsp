<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>리뷰작성</title>
</head>
<body>
<form action="/reviewUpdate">
	<table>
		<tr>
			<th>후기번호</th>
			<th>캠핑장번호</th>
			<th>회원번호</th>
			<th>작성일</th>
			<th>내용</th>
			<th>총점</th>
			<th>시설별점</th>
			<th>환경별점</th>
			<th>서비스별점</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>

		<tr>
			<th><input type="hidden" name="review_no"
				value="${dto.review_no}">${dto.review_no}</th>
			<th>${dto.campsite_no}</th>
			<th>${dto.member_no}</th>
			<th>${dto.create_date}</th>
			<th><input type="text" name="content" value="${dto.content}"></th>
			<th>${dto.star_rating}</th>
			<th><input type="text" value="${dto.fcl_rating}"
				name="fcl_rating"></th>
			<th><input type="text" value="${dto.fcl_rating}"></th>
			<th><input type="text" value="${dto.env_rating}"></th>
			<th><input type="text" value="${dto.service_rating}"></th>
			<th><input type="submit" value="수정"></th>
			<th><a href="/reviewDelete?review_no=${dto.review_no}">삭제</a></th>
		</tr>
	</table>
</form>	
<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a4311adb6e1c8e2e4bdef6d9d507e8a5&libraries=services"></script>
<script>
console.log("왜안돼");
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 
</script>
    
</body>
 
</html>