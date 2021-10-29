<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.work.wecamp.member.controller.MemberController" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
	var data = ${updateresult};	
	if(data != null)
		alert("회원정보가 변경되었습니다. 재로그인 후 이용해주세요.");

	var result = ${result};
	if(result != null)
		alert("회원탈퇴 완료되었습니다. 그동안 wecamp를 사용해주셔서 감사합니다.");

	var failLogin = ${loginCheck};
	if(failLogin)
		alert("아이디 혹은 비밀번호가 일치하지 않습니다.");

	var failDelete = ${deleteCheck};
	if(failDelete)
		alert("비밀번호가 일치하지 않습니다.");
</script>
</head>

<body>
	<c:choose>
		<c:when test="${empty memberId}">
		<nav class="navbar navbar-light bg-light fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">WECAMP</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">WECAMP</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/loginForm">회원가입 및 로그인</a>
          </li>
           
          
        </ul>
      </div>
    </div>
  </div>
</nav>
		</c:when>
		<c:otherwise>
		<nav class="navbar navbar-light bg-light fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="main">WECAMP</a>
    <a class="navbar-brand">${username}님 환영합니다.</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">WECAMP</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="main">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="logout">로그아웃</a>
            <a class="nav-link" href="/member/myInfo">내정보조회</a>
            <a class="nav-link" href="/member/deleteForm">회원탈퇴</a>
          </li>
          
        </ul>
      </div>
    </div>
  </div>
</nav>
		</c:otherwise>
	</c:choose>
	
</body>
</html>