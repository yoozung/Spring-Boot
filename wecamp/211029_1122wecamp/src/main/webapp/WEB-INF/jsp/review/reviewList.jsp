<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰목록</title>
<link type="text/css" rel="stylesheet" href="/resource/css/review.css">
</head>
<body>
	<div id="map" style="width: 100%; height: 350px;"></div>
	<div class="reviewList_div">
		<form action="/reviewDetail" method="post">
			<table class="reviewList_table">
				<c:forEach var="r" items="${list}">
					<tr>
						<td>총점 : ${r.starRating}</td>
						<td>작성일 : ${r.createDate}</td>
						<td>시설별점 : ${r.fclRating}</td>
						<td>환경별점 : ${r.envRating}</td>
						<td>서비스별점 : ${r.serviceRating}</td>
						<td>내용 : ${r.content}</td>
						<td>후기 번호 : <a href="/reviewDetail?reviewNo=${r.reviewNo}"
							name="reviewNo" value="${r.reviewNo}">${r.reviewNo}</a></td>
						<td>캠핑장 번호 : ${r.campsiteNo}</td>
						<td>회원번호 : ${r.memberNo}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>

<script>
	var mapContainer = document.getElementById('map'),  
	mapOption = {
		center : new kakao.maps.LatLng(33.450701, 126.570667),  
		level : 3 
	};

	var map = new kakao.maps.Map(mapContainer, mapOption);  
 
	var markerPosition = new kakao.maps.LatLng(33.450701, 126.570667);
 
	var marker = new kakao.maps.Marker({
		position : markerPosition
	});
 
	marker.setMap(map); 
</script>
</html>