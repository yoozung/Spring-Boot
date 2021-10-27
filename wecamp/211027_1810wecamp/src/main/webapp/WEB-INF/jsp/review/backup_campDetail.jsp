<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장상세조회</title>
<link type="text/css" rel="stylesheet" href="/resource/css/camp_detail.css">
<link type="text/css" rel="stylesheet" href="/resource/js/review.js">
<!-- start Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<!-- end Bootstrap -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=57f35dff503fc90b1fc42984b5f06cab"></script>

</head>
<body>
	<div class="div-detail">
		<div class="detail-content">
			<img class="main-img"
				src="https://images.unsplash.com/photo-1504280390367-361c6d9f38f4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80">

			<h2 class="camp_nm">고운마을캠핑장</h2>
			<button type="button" class="btn btn-light">Reserve</button>
			<hr>
			<table class="camp-detail-table">
				<tr>
					<td class="camp-detail-content">
						<div class="content-category">주소</div>
						<div>경기도 양평군 서종면 23-34</div> <br>
						<div class="content-category">소개글</div>
						<div class="intro-content">청춘의 끓는 피가 아니더면 인간이 얼마나 쓸쓸하랴? 얼음에
							싸인 만물은 얼음이 있을 뿐이다 그들에게 생명을 불어 넣는 것은 따뜻한 봄바람이다 풀밭에 속잎나고 가지에 싹이 트고
							꽃 피고 새 우는 봄날의 천지는 얼마나</div> <br>
						<div class="content-category">업종</div>
						<div>일반 글램핑</div> <br>
					</td>
				</tr>
			</table>
			<hr>
			<div class="info-title">기본정보</div>
			<table class="camp-detail-table">
				<tr>
					<td class="camp-detail-content">
						<div class="content-category">연락처</div>
						<div>010-123-1234</div> <br>
						<div class="content-category">홈페이지</div>
						<div class="intro-content">http://cafe.naver.com/jirisancamping</div>
						<br>
						<div class="content-category">입지형태</div>
						<div>바다</div> <br>
						<div class="content-category">운영기간</div>
						<div>봄,여름</div> <br>
					</td>
				</tr>
			</table>
			<hr>
			<div class="info-title">부가정보</div>
			
			<table class="camp-detail-table">
				<tr>
					<td class="camp-detail-content">
						<div class="content-category">운영일</div>
						<div>010-123-1234</div> <br>
						<div class="content-category">개인 트레일러 동반 가능 여부</div>
						<div class="intro-content">http://cafe.naver.com/jirisancamping</div>
						<br>
						<div class="content-category">입지형태</div>
						<div>바다</div> <br>
						<div class="content-category">운영기간</div>
						<div>봄,여름</div> <br>
					</td>
				</tr>
			</table>
			<div class="location">고운마을캠핑장은 [강원도 강릉시 강릉대로 121번길 37-4]에 위치해 있습니다.</div><br>
			<div id="map" style="width: 100%; height: 350px;"></div>
			<hr>
			<img class="star-img"
				src="data:image/png;base64,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">
			<div class="review-part">
				<h4>후기 40개</h4>
			</div>

			<div class="star-table-box">
				<table class="star-table">
					<tr>
						<td class="">
							<div>시설 ★4.5</div>
							<div>환경 ★4.5</div>
							<div>서비스 ★4.5</div>
						</td>
					</tr>
				</table>
			</div>

			<table class="review-table">
				<tr>
					<td class="review-table-content">
						<div class="review-content-box">
							<div class="review-content">
								<h4>홍길동</h4>
								<div class="review-date">2021.01.23</div>
								<img class="ministar-img"
									src="data:image/png;base64,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">
								<div>4.5</div>
								<div>숲 속에 있어서 너무 좋은 캠핑장입니다.</div>
							</div>
						</div> <br>
					</td>
				</tr>
			</table>
			<button type="button" class="btn btn-outline-success">후기등록</button>
		</div>
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