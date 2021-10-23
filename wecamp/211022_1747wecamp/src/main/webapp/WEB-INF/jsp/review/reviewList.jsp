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
<body style="text-align:center; margin-left:auto; margin-right:auto;">
<div class="reviewList_div">
	<form action="/reviewDetail" method="post">
		<table class="reviewList_table">
			<c:forEach var="r" items="${list}">
				<tr> 	
					<td>총점 : ${r.star_rating}</td>
					<td>작성일 : ${r.create_date}</td>
					<td>시설별점 : ${r.fcl_rating}</td>
					<td>환경별점 : ${r.env_rating}</td>
					<td>서비스별점 : ${r.service_rating}</td>
					<td>내용 : ${r.content}</td>
					<td>후기 번호 : <a href="/reviewDetail?review_no=${r.review_no}" name="review_no" value="${r.review_no}">${r.review_no}</a></td>
					<td>캠핑장 번호 : ${r.campsite_no}</td>
					<td>회원번호 : ${r.member_no}</td> 
				</tr>
			</c:forEach>
		</table>
	</form>
	</div>
</body>
</html>