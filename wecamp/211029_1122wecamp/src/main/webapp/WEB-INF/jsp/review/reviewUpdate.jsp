<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰수정</title>
</head>
<body>
	<c:forEach var="dto" items="${list}">
		<table>
			<tr>
				<th>작성일</th>
				<th>총점</th>
				<th>시설별점</th>
				<th>환경별점</th>
				<th>서비스별점</th>
			</tr>

			<tr>
				<th>${dto.createDate}</th>
				<th>${dto.starRating}</th>
				<th>
					<!-- 기본값 설정하고 싶다 value로 안된다--> 
					<select name="fcl_rating" value="${dto.fclRating}">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select>
				</th>
				<th><select name="fcl_rating" value="${dto.envRating}">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select></th>
				<th><select name="fcl_rating" placeholder="${dto.serviceRating}">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select></th>
			</tr>
		</table>
		<input type="text" value="${dto.reviewNo}">
	</c:forEach>
</body>
</html>