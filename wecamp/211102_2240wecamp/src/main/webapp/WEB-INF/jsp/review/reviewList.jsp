<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰목록</title>
<link type="text/css" rel="stylesheet" href="/css/review/review.css">
 
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<style type="text/css">
	.header-logo{
    color : white;
    font-weight: 700;
    text-decoration: none;
    font-size : 2em;
    text-transform: uppercase;
    letter-spacing: 2px;
}

body{
	background-color: black;
}
	
	</style>
</head>
<body>
	<div id="map" style="width: 100%; height: 350px;"></div>
	<div class="reviewList_div">
		 
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
						<td>이름 : ${r.username}</td>
						
					</tr>
				</c:forEach>
			</table>
	</div>
	  <a href="/" class="header-logo">
                <i class="fal fa-campground"></i>
                wecamp
            </a>
    
	
</body>


</html>