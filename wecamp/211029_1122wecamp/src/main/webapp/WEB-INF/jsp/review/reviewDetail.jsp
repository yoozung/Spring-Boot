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
<form action="/reviewUpdate" method="get">
	<table>
		<tr>
			<th>리뷰번호</th>
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
			
			<th>${dto.reviewNo}</th>
			<th>${dto.campsiteNo}</th>
			<th>${dto.memberNo}</th>
			<th>${dto.createDate}</th>
			<th><input type="text" value="${dto.content}"  readonly="readonly" name="content"></th>
			<th><input type="text" value="${dto.starRating}" name="starRating" re></th>
			<th><input type="text" value="${dto.fclRating}" name="fclRating"></th>
			<th><input type="text" value="${dto.envRating}" name="envRating"></th>
			<th><input type="text" value="${dto.serviceRating}" name="serviceRating"></th>
			<th><input type="submit" value="수정"></th>
			<th><a href="/reviewDelete?reviewNo=${dto.reviewNo}">삭제</a></th>
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