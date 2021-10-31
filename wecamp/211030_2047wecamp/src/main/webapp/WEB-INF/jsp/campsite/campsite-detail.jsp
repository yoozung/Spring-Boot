<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장상세조회</title>
<link type="text/css" rel="stylesheet"
	href="/css/camp/camp-detail.css">
	
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
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=57f35dff503fc90b1fc42984b5f06cab"></script>

</head>
<body class="body">
	<div class="div-detail">
		<div class="detail-content">
			<img class="main-img" src="${campsite.thumbnail}">
			<div class="nm_btn">
				<h2 class="camp_nm">${campsite.facltNm}</h2>
				<c:if test="${campsite.resveUrl ne null}">
				<a href="${campsite.resveUrl}"><button type="button" class="btn btn-light">Reserve</button></a>
				</c:if>
			</div>
			
			 
			
			
			<hr class="top-line">
			<div class="camp-main-div">
				<table class="camp-detail-table">
					<tr>
						<td class="camp-detail-content"><c:choose>
								<c:when test="${campsite.lineIntro eq null}">
									<div class="content-category">해당 캠핑장에서 등록한 한 줄 소개가 없습니다.</div>
								</c:when>
								<c:otherwise>
									<div class="content-category">${campsite.lineIntro}</div>
									<br>
								</c:otherwise>
							</c:choose>
							<div class="main-line"></div> <c:choose>
								<c:when test="${campsite.detailIntro eq null}">
									<div class="intro-content">해당 캠핑장에서 등록한 캠핑장 소개가 없습니다.</div>
								</c:when>
								<c:otherwise>
									<div class="intro-content">${campsite.detailIntro}</div>
									<br>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</table>
			</div>


			<hr class="basic-info-line">
			<div class="info-title">기본정보</div>
			<table class="camp-detail-table">
				<tr>
					<td class="camp-detail-content">
						<div class="col-text-box">
							<div class="content-category">연락처</div>
							<c:if test="${campsite.tel eq null}">
								<div class="content-category">해당 캠핑장에서 등록한 전화번호가 없습니다.</div>
							</c:if>
							<c:if test="${campsite.trlerYn ne null}">
								<div>${campsite.tel}</div>
								<br>
							</c:if>
						</div>

						<div class="col-text-box">
							<div class="content-category">홈페이지</div>
							<c:if test="${campsite.homepage eq null}">
								<div class="content-category">해당 캠핑장에서 등록한 홈페이지가 없습니다.</div>
							</c:if>
							<c:if test="${campsite.homepage ne null}">
								<div>
									<a href="${campsite.homepage}">${campsite.homepage}</a>
								</div>
								<br>
							</c:if>
						</div>


						<div class="col-text-box">
							<div class="content-category">업종</div>
							<c:if test="${campsite.induty eq null}">
								<div class="content-category">해당 캠핑장에서 선택한 업종이 없습니다.</div>
							</c:if>
							<c:if test="${campsite.induty ne null}">
								<div>${campsite.induty}</div>
								<br>
							</c:if>

							<div class="col-text-box">
								<div class="content-category">입지</div>
								<c:if test="${campsite.lctCl eq null}">
									<div class="content-category">해당 캠핑장에서 선택한 입지가 없습니다.</div>
								</c:if>
								<c:if test="${campsite.lctCl ne null}">
									<div>${campsite.lctCl}</div>
									<br>
								</c:if>
							</div>
						</div>
					</td>
				</tr>
			</table>
			<div class="location">${campsite.facltNm}은[${campsite.doNm}
				${campsite.sigungu} ${campsite.addr1} ${campsite.addr2} (우편번호:
				${campsite.zipcode})] 에 위치해 있습니다.</div>
			<br>
			<div id="map" style="width: 70%; height: 500px; margin: auto;"></div>


			<hr class="operate-info-line">
			<details>
				<summary class="info-title">운영정보</summary>
				<p>
				<table class="camp-detail-table">
					<tr>
						<td class="camp-detail-content">
							<div class="col-text-box">
								<div class="content-category">운영시기</div>
								<div>${campsite.operationP}</div>
								<br>
							</div>

							<div class="col-text-box">
								<div class="content-category">운영일</div>
								<div class="intro-content">${campsite.operationD}</div>
								<br>
							</div>

							<div class="col-text-box">
								<div class="content-category">개인트레일러동반여부</div>
								<c:if test="${campsite.trlerYn eq 'Y'}">
									<div>가능</div>
									<br>
								</c:if>
								<c:if test="${campsite.trlerYn eq 'N'}">
									<div>불가능</div>
									<br>
								</c:if>
							</div>

							<div class="col-text-box">
								<div class="content-category">개인카라반동반여부</div>
								<c:if test="${campsite.caravYn eq 'Y'}">
									<div>가능</div>
									<br>
								</c:if>
								<c:if test="${campsite.caravYn eq 'N'}">
									<div>불가능</div>
									<br>
								</c:if>
							</div>

							<div class="col-text-box">
								<div class="content-category">애완동물동반여부</div>
								<div>${campsite.animalCmg}</div>
								<br>
							</div>
						</td>
					</tr>
				</table>
				</p>
			</details>

			<hr class="seperate-line">
			<details>
				<summary class="info-title">부가정보</summary>
				<p>
					<c:if test="${campsite.sbrsCl ne null}">
						<c:set var="etc" value="${campsite.sbrsCl}" />
						<div class="etc-fcl-icon-div">
							<c:if test="${fn:contains(etc, '온수')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/hot-water.png"
										class="fcl_icon"> <span class="fcl_category">온수</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '전기')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/electric.png"
										class="fcl_icon"> <span class="fcl_category">전기사용</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '운동장')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/ground.png"
										class="fcl_icon"> <span class="fcl_category">운동장</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '산책로')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/walk.png"
										class="fcl_icon"> <span class="fcl_category">산책로</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '운동시설')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/gymnasium.png"
										class="fcl_icon"> <span class="fcl_category">운동시설</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '마트')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/mart.png"
										class="fcl_icon"> <span class="fcl_category">마트</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '놀이터')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/playground.png"
										class="fcl_icon"> <span class="fcl_category">놀이터</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '편의점')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/shop.png"
										class="fcl_icon"> <span class="fcl_category">편의점</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '물놀이장')}">
								<div class="fcl_one">
									<img
										src="/img/campingDetail/etc_fcl/swimming-pool.png"
										class="fcl_icon"> <span class="fcl_category">물놀이장</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '무선인터넷')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/wifi.png"
										class="fcl_icon"> <span class="fcl_category">무선인터넷</span>
								</div>
								<br>
							</c:if>

							<c:if test="${fn:contains(etc, '장작판매')}">
								<div class="fcl_one">
									<img src="/img/campingDetail/etc_fcl/firewood.png"
										class="fcl_icon"> <span class="fcl_category">장작판매</span>
								</div>
								<br>
							</c:if>
						</div>
					</c:if>
					
				<div class="etc-fcl-box">
				<div class="col-text-box">
					<c:if test="${campsite.sbrsEtc ne null}">
						<div class="content-category">부대시설 기타</div>
						<div>${campsite.sbrsEtc}</div>
						<br>
					</c:if>
</div>

<div class="col-text-box">
					<c:if test="${campsite.posblFcl ne null}">
						<div class="content-category">주변이용가능시설</div>
						<div>${campsite.posblFcl}</div>
						<br>
					</c:if>
</div>

<div class="col-text-box">
					<c:if test="${campsite.themaEnv ne null}">
						<div class="content-category">주변테마환경이용가능시설</div>
						<div>${campsite.themaEnv}</div>
						<br>
					</c:if>
</div>
				</div>
				</p>
			</details>

			<!----------------------------------------- 글램핑내부시설----------------------------------------->

			<c:if test="${campsite.glampInner ne null}">
				<hr class="seperate-line">
				<details>
					<summary class="info-title">글램핑내부시설</summary>
					<p>
						<c:set var="etc" value="${campsite.glampInner}" />
					<div class="etc-fcl-icon-div">

						<c:if test="${fn:contains(etc, '침대')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/bed.png"
									class="fcl_icon"> <span class="fcl_category">침대</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '취사도구')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/cook.png"
									class="fcl_icon"> <span class="fcl_category">취사도구</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '내부화장실')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/toilet.png"
									class="fcl_icon"> <span class="fcl_category">내부화장실</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '내부샤워실')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/shower.png"
									class="fcl_icon"> <span class="fcl_category">내부샤워실</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '유무선인터넷')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/wifi.png"
									class="fcl_icon"> <span class="fcl_category">유무선인터넷</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '티비')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/tv.png"
									class="fcl_icon"> <span class="fcl_category">티비</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '에어컨')}">
							<div class="fcl_one">
								<img
									src="/img/campingDetail/glamping_fcl/air-conditioner.png"
									class="fcl_icon"> <span class="fcl_category">에어컨</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '냉장고')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/fridge.png"
									class="fcl_icon"> <span class="fcl_category">냉장고</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '난방기구')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/heater.png"
									class="fcl_icon"> <span class="fcl_category">난방기구</span>
							</div>
							<br>
						</c:if>
					</div>
					</p>
				</details>
			</c:if>

			<!----------------------------------------- 카라반내부시설----------------------------------------->

			<c:if test="${campsite.caravanInner ne null}">
				<hr class="seperate-line">
				<details>
					<summary class="info-title">카라반내부시설</summary>
					<p>
						<c:set var="etc" value="${campsite.caravanInner}" />
					<div class="etc-fcl-icon-div">

						<c:if test="${fn:contains(etc, '침대')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/bed.png"
									class="fcl_icon"> <span class="fcl_category">침대</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '취사도구')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/cook.png"
									class="fcl_icon"> <span class="fcl_category">취사도구</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '내부화장실')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/toilet.png"
									class="fcl_icon"> <span class="fcl_category">내부화장실</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '내부샤워실')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/shower.png"
									class="fcl_icon"> <span class="fcl_category">내부샤워실</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '유무선인터넷')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/wifi.png"
									class="fcl_icon"> <span class="fcl_category">유무선인터넷</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '티비')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/tv.png"
									class="fcl_icon"> <span class="fcl_category">티비</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '에어컨')}">
							<div class="fcl_one">
								<img
									src="/img/campingDetail/glamping_fcl/air-conditioner.png"
									class="fcl_icon"> <span class="fcl_category">에어컨</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '냉장고')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/fridge.png"
									class="fcl_icon"> <span class="fcl_category">냉장고</span>
							</div>
							<br>
						</c:if>

						<c:if test="${fn:contains(etc, '난방기구')}">
							<div class="fcl_one">
								<img src="/img/campingDetail/glamping_fcl/heater.png"
									class="fcl_icon"> <span class="fcl_category">난방기구</span>
							</div>
							<br>
						</c:if>
					</div>
					</p>
				</details>
			</c:if>

			<!----------------------------------------- 리뷰----------------------------------------->

			<hr class="review-line">
			<!-- <img class="star-img"
				src="data:image/png;base64,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">
			 -->
			<div class="review-part">
				<h4>★ 4.7 · 후기 40개</h4>
			</div>

			<div class="star-table-box">
				<div class="star-box">
					<div class="star-onebox">
						<span class="star-name">시설</span> <span class="star">★</span> <span
							class="star-rate">4.5</span>
					</div>
					<div>
						<span class="star-name">환경</span> <span class="star">★</span> <span
							class="star-rate">4.5</span>
					</div>
					<div>
						<span class="star-name">서비스</span> <span class="star">★</span> <span
							class="star-rate">4.5</span>
					</div>
				</div>
			</div>

		<c:forEach var="r" items="${list}">
			<table class="review-table">
				<tr>
					<td class="review-table-content">
						<div class="review-content-box">
							<div class="review-content">
								<h4>${r.username}</h4>
								<!--  <h4>${member_no}</h4>-->
								<div class="review-date"> ${r.createDate}</div>
								<img class="ministar-img"
									src="data:image/png;base64,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">
								<div>${r.starRating}</div>
								<div>${r.fclRating}</div>
								<div>${r.envRating}</div>
								<div>${r.serviceRating}</div>
								<div>${r.content}</div>
								<div>후기 번호 : <a href="/reviewDetail?reviewNo=${r.reviewNo}"
							name="review_no" value="${r.reviewNo}">${r.reviewNo}</a></div>
							</div>
						</div> <br>
					</td>
				</tr>
			</table>

			</c:forEach>
			<div class="review-btn">
				<button type="button" class="btn btn-outline-success"
					onclick="reviewWrite()">후기등록</button>
			</div>
		</div>
	</div>
	
	<!--==============================================================================-->
	<input type="hidden" value="${campsite.lon}" id="lon">
	<input type="hidden" value="${campsite.lat}" id="lat">
	<input type="hidden" value="${campsite.campsiteNo}" id="campsiteNo">
	<!--==============================================================================-->
 
				
					<c:if test="${dto.member_no ne null}">
					 <c:forEach var="r" items="${like}">
					 
					  <!-- 좋아요 안 돼 있을 때 -->
					  <form action="/like">
						<c:if test="${r.likeYn eq 0}">
								<input type="text" name="campsiteNo"
									value="${r.campsiteNo}">
								<input type="text" name="memberNo" value="${r.memberNo}">
								<input type="text" name="likeYn" value="${r.likeYn}">
								<input type="text" name="likeYn" value="${r.likeCn}">
								<input type="submit" value="♡">
					 </c:if>
					 </form>
					 
					 <!-- 좋아요 돼 있을 때 -->
					 <form action="/dislike">
					 <c:if test="${r.likeYn eq 1}">
								<input type="text" name="campsiteNo"
									value="${r.campsiteNo}">
								<input type="text" name="memberNo" value="${r.memberNo}">
								<input type="text" name="likeYn" value="${r.likeYn}">
								<input type="text" name="likeYn" value="${r.likeCn}">
								<input type="submit" value="♥">
					 </c:if>
					 </form>
					 
					</c:forEach>
					</c:if>
				<c:if test="${dto.member_no eq null}"></c:if>
		 


</body>
<script>
function reviewWrite() {
	location.href="/review?no=" + "${campsite.campsiteNo}" ;
}



var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng(${campsite.lat},  ${campsite.lon}), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//마커를 표시할 위치입니다 
var position =  new kakao.maps.LatLng(${campsite.lat},  ${campsite.lon});

//마커를 생성합니다
var marker = new kakao.maps.Marker({
position: position
});

//마커를 지도에 표시합니다.
marker.setMap(map);

//마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
var iwContent = '<div style="padding:10px; height:auto; overflow:auto;">${campsite.facltNm}</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

//인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
content : iwContent
});

//마커에 마우스오버 이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'mouseover', function() {
// 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
infowindow.open(map, marker);
});

//마커에 마우스아웃 이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'mouseout', function() {
// 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
infowindow.close();
});
</script>
<script src="/js/review.js"></script>
</html>