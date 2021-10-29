<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.work.wecamp.member.controller.MemberController" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/css/member/login.css">
<script>
	var joinresult = ${joinresult};
	
	if(joinresult != null)
		alert("회원가입이 완료되었습니다. 로그인 후 이용해주세요.");
</script>
</head>
<body>
<main id="main">
			<!-- 화면에 보여질 콘텐츠 박스 --> 
			<div class="inner">
				<!-- flexbox -->
				<article class="main-container">
					<h2>로그인</h2>
					
					<section class="item item1">
						<h3  style="display:none">로그인 폼</h3>
						
						<div class="login-form">
							<form action="/login" method="POST">
								<div class="input-key">
									<input type="text" size="40" name="memberId" placeholder="아이디를 입력해주세요"/>
								</div>
								
								<div class="input-key">
									<input type="password" size="40" name="memberPw" placeholder="비밀번호를 입력해주세요"/>
								</div>
								<div class="login-box">
									<button type="submit" class="login-button">로그인</button>
								</div>
								<a href="/oauth2/authorization/google"><img height="65px"src="/img/google_login_button.png"></a><br/>
								<a href="/oauth2/authorization/naver"><img height="65px"src="/img/naver_login_button.png"></a><br/>
								<a href="/oauth2/authorization/kakao"><img height="65px"src="/img/kakao_login_button.png"></a><br/><br/><br/>						
							</form>									
						</div>
						
						<div class="join-box">
							<button class="join-button" onclick = "location.href = 'joinForm' ">회원가입</button>
						</div>	
						
					</section>
				</article>
			</div>
		</main>
</body>
</html>