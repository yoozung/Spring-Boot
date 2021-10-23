<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰목록</title>
<style type="text/css">
table ,tr ,th {
	border=1px;
}
</style>
</head>
<body>
	<form action="/reviewDetail" method="post">
		<table>
			<c:forEach var="r" items="${list}">
				<tr>
					
					<th>작성일 : ${r.create_date}</th> 
					<th>총점 : ${r.star_rating}</th>
					<th>시설별점 : ${r.fcl_rating}</th>
					<th>환경별점 : ${r.env_rating}</th>
					<th>서비스별점 : ${r.service_rating}</th>
					<th>내용 : ${r.content}"</th>
					
					<th>후기 번호 : <a href="/reviewDetail?review_no=${r.review_no}" name="review_no" value="${r.review_no}">${r.review_no}</a></th>
					<th>캠핑장 번호 : ${r.campsite_no}</th>
					<th>회원번호 : ${r.member_no}</th>
					
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>