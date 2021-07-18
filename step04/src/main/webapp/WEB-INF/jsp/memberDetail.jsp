<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체회원조회</title>
<style type="text/css">
 table, tr, th, td {
 	padding: 2px;
 	color: maroon;
 	border-color: lime;
 }
</style>
</head>
<body>
<h3>전체회원조회 </h3>
<form action="memberDetail" method="post">
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>등급</th>
			<th>마일리지</th>
			<th>담당자</th>
		</tr>
		
		<c:forEach var="dto" items="${list} varStatus="status"> 
			<tr>
				<th></th>
				<th><a href="memberDetail?memberId=${dto.memberId}">${dto.memberId}</a></th> 
				<th>${fn:substring(dto.memberPw, 0, 2)}<c:forEach begin="2" end="${fn:length(dto.memberPw)}" step="1">*</c:forEach></th>
				<th>${dto.name}</th>
				<th>${dto.mobile}</th>
				<th>${dto.email}</th>
				<th>${dto.entryDate}</th>
				<th>${dto.grade}
				<c:choose>
					<c:when test="${dto.grade == 'G' }">[일반회원]</c:when>
					<c:when test="${dto.grade == 'S' }">[우수회원]</c:when>
					<c:when test="${dto.grade == 'A' }">[관리자]</c:when>
				</c:choose>
				</th>
				<th>${dto.mileage}</th>
				<th>${dto.manager}</th>
			</tr>
	</c:forEach>
	</table>
</form>

</body>
</html>