<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/Taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰목록</title>
</head>
<body>
<form action="/reviewDetail" method="post">
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
			<th>상세</th>
			
		</tr>

		<c:forEach var="r" items="${list}">
			<tr>
				<th><a href="/reviewDetail?review_no=${r.review_no}" name="review_no" value="${r.review_no}">${r.review_no}</a></th>
				<th>${r.campsite_no}</th>
				<th>${r.member_no}</th>
				<th>${r.create_date}</th>
				<th>${r.content}"</th>
				<th>${r.star_rating}</th>
				<th>${r.fcl_rating}</th>
				<th>${r.fcl_rating}</th>
				<th>${r.env_rating}</th>
				<th>${r.service_rating}</th>
			</tr>
		</c:forEach>
	</table>
</form>
</body>

</html>