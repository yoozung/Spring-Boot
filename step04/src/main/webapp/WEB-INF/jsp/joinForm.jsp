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
<h3> step02 </h3>

<h3>회원가입</h3>
<form action="join" method="post">
	<input type="text" name="memberId" placeholder="아이디" autofocus="autofocus"/>
	<input type="password" name="memberPw" placeholder="비밀번호" required="required"/>
	<input type="text" name="name" placeholder="이름" required="required"/>
	<input type="text" name="mobile" placeholder="휴대폰" required="required"/>
	<input type="text" name="email" placeholder="이메일" required="required"/>
	<input type="submit" value="가입"/>
	<input type="reset" value="취소"/>


</form>
</body>
</html>