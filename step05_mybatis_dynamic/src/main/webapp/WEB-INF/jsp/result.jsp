<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl -->    
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link type="text/css"  rel="stylesheet" href="/css/common.css">
</head>
<body>
<a href="main"><img src="/img/snu.jpg"></a>
<a href="joinForm">회원가입</a>
<a href="loginForm">로그인</a>
<a href="memberList">전체회원조회</a>
<h3> step02 </h3>

<h3>메세지</h3>
<C:if test="${not empty message}">
	${message}
</C:if>
<C:if test="${not empty loginId}">
	${loginId}
</C:if>


</body>
</html>