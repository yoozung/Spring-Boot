<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../inc/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>리뷰상세(수정삭제가능)</title>
</head>
<body>
<form action="/reviewUpdate?reviewNo=${dto.reviewNo}">
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
			<th><input type="hidden" value="${dto.reviewNo}" name="reviewNo">${dto.reviewNo}</th>
			<th><input type="hidden" value="${dto.campsiteNo}" name="campsiteNo">${dto.campsiteNo}</th>
			<th><input type="hidden" value="${dto.memberNo}" name="memberNo">${dto.memberNo}</th>
			<th><input type="hidden" value="${dto.createDate}" name="createDate">${dto.createDate}</th>
			
			<th><input type="text" value="${dto.content}" name="content"></th>
		
			<th><input type="hidden" value="${dto.starRating}" name="starRating">${dto.starRating}</th>
			<th><input type="text" value="${dto.fclRating}" name="fclRating"></th>
			<th><input type="text" value="${dto.envRating}" name="envRating"></th>
			<th><input type="text" value="${dto.serviceRating}" name="serviceRating"></th>
			
			<th><input type="submit" value="수정"></th>
			<th><a href="/reviewDelete?reviewNo=${dto.reviewNo}">삭제</a></th>
		</tr>
	</table>
	</form>



</body>
 
</html>