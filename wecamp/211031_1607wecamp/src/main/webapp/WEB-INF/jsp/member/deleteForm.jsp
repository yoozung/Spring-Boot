<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.work.wecamp.member.model.Member" %>
<%@ page import="com.work.wecamp.member.controller.MemberController" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>

<link rel="stylesheet" href="/css/member/login.css">

</head>
<body>
<main id="main">
			<!-- 화면에 보여질 콘텐츠 박스 --> 
			<div class="inner">
				<!-- flexbox -->
				<article class="main-container">
					<h2>회원탈퇴</h2>
					
					
					<section class="item item1">
						<h3  style="display:none">회원탈퇴 폼</h3>
						
						<div class="login-form">
							<form name="frm" action="/delete" method="POST">
								<div class="input-key">
									<input class="id_input" type="text" id="user-id" name="memberId" size="40" 
                        					value=${ memberId } readonly="readonly">
								</div>
								
								<div class="input-key">
									<input type="password" size="40" name="memberPw" placeholder="비밀번호를 입력해주세요"/>
								</div>
								<h3>회원탈퇴사유를 입력해주세요. 여러분의 소중한 의견이 더 나은 WECAMP를 만드는데 큰 도움이 됩니다!</h3>
								<div class="input-key">
									<input type="text" size="150"  />
								</div>
								
								<div class="login-box">
									<button type="submit" id="Send" class="login-button">회원탈퇴</button>
								</div>							
							</form>									
						</div>
						
						<div class="join-box">
							<button class="join-button" onclick = "location.href = '/member/login' ">취소</button>
						</div>	
						
					</section>
				</article>
			</div>
		</main>
</body>
</html>