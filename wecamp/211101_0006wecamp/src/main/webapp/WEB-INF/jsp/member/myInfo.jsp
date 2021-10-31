<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.work.wecamp.member.model.Member" %>
<%@ page import="com.work.wecamp.member.controller.MemberController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/join.css">
<link rel="stylesheet" href="/css/member/join2.css">

</head>
<body>

<main id="main">
			<!-- 화면에 보여질 콘텐츠 박스 --> 
			<div class="inner">
				<!-- flexbox -->
				<article class="main-container">
					<h2>내정보조회</h2>
					<section class="item item1">
						<h3  style="display:none">내정보조회폼</h3>
						<div class="join-form">
							<form name="frm" id="join_form" method="post" action="/myInfoUpdate">
								<div class="nec-input">
									<span class="esq">*</span>
									<span>필수입력사항</span>
								</div>
								
								<table class="input-table">
								
									<tr>
										<th>
											아이디
											<span class="esq ">*</span>
										</th>
										<td>
                        					<input class="id_input" type="text" id="user-id" name="memberId" size="40" 
                        					value=${ memberId } readonly="readonly">
										</td>
										
									</tr>
									<tr>
										<th>
											비밀번호
											<span class="esq">*</span>
										</th>
										<td>
                        					<input class="pw_input" type="password" id="user-password" size="40" name="memberPw" placeholder="비밀번호를 입력해주세요">
										<span class="final_pw_ck">비밀번호를 입력해주세요.</span>
										</td>
									</tr>									
									<tr>
										<th>
											비밀번호확인
											<span class="esq">*</span>
										</th>
										<td>
                        					<input class="pwck_input" type="password" id="user-password-chk" name="memberPw2" size="40" placeholder="비밀번호를 한번 더 입력해주세요">
										<span class="final_pwck_ck">비밀번호 확인을 입력해주세요.</span>
										<span class="pwck_input_re_1">비밀번호가 일치합니다.</span>
										<span class="pwck_input_re_2">비밀번호가 일치하지 않습니다.</span>
										</td>
									</tr>
									<tr>
										<th>
											이름
											<span class="esq">*</span>
										</th>
										<td>
                        					<input class="user_input" type="text" id="user-name" name="username" placeholder="이름을 입력해주세요" size="40"
                        					value=${ username }>
										<span class="final_name_ck">이름을 입력해주세요.</span>
										</td>
									</tr>
									<tr>
										<th>
											이메일
											<span class="esq">*</span>
										</th>
										<td>
                        					<input class="mail_input" type="text" id="email" name="email" placeholder="ex)doeat@eat.com" size="40"
                        					value=${ email }>
										<span class="final_mail_ck">이메일을 입력해주세요.</span>
										</td>
									</tr>
									<tr>
										<th>
											휴대폰
											<span class="esq">*</span>
										</th>
										<td>
                        					<input class="mobile_name" type="text" id="phone" name="mobile" placeholder="숫자만 입력해주세요" size="40"
                        					value=${ mobile }>
										<span class="final_mobile_ck">휴대폰 번호를 입력해주세요.</span>
										</td>
										
										
									</tr>					
										
								</table>
								<div class="submit-box">
									<div class="join-box">
										<button type="button" id="Send" class="join-button">내정보변경</button>
									</div>
								</div>		
							</form>			
								<div class="cancel-box">
									<button class="cancel-button" onclick="location.href='/member/login' ">취소하기</button>
								</div>
						</div>
					</section>
				</article>
			</div>
		</main>
<script src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/js/member/join.js"></script>
<script type="text/javascript" src="/js/member/infoUpdate.js"></script>
</body>
</html>