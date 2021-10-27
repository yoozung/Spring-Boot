<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑장조회</title>
	<link rel="stylesheet" href="/resource/css/normalize.css" />
	<link rel="stylesheet" href="/resource/css/common.css"/>
	<link rel="stylesheet" href="/resource/css/campSearch.css" />
	<link rel="stylesheet" href="/resource/css/campToggle.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	
	<!-- 전체를 감싸는 태그 -->
	<div class="wrapper">
		<!-- 시멘틱 태그 -->
		<main id="main">
			<!-- 화면에 보여질 태그 -->
			<div class="inner">
			
			<!-- 검색조건 컨테이너 -->
				<div id="camp-container">
					<!-- 검색어 박스  -->
					<div class="search-container">
					    <div class="search-box">
					        <input class="search-txt" type="text" name="" placeholder="Search">
					        <a class="search-btn" href="#">
					            <i class="fas fa-search"></i>
					        </a>
					    </div>
					</div>
					
					<!-- 접었다 펼치기 -->
					<div class="toggle-box">
						<button class="question" id="que-1">
							<span id="faq-title">지역검색</span>
							<span id="que-1-toggle">+</span>
						</button>
						
						<div class="faq-content">
						  <div class="answer" id="ans-1">
						  	<!-- 도이름 출력  -->
						  		<div class="do-box">
						  		  
						  		</div>
						  	<!-- 시군구 이름 출력 -->
						  		<div class="sigungu-box">
									
								</div>
						  </div>
						</div>

					</div>
					
				 	<div class="toggle-box">
						<button class="question" id="que-2">
						<span id="faq-title">고급검색</span>
						<span id="que-2-toggle">+</span></button>
						<div class="faq-content">
						  <div class="answer" id="ans-2">
						  		<div class="option-box">
						  			<input type="radio" name="camp-option" onclick="campOption(this.value)" /> 애완동물출입여부
						  			<input type="radio" name="camp-option" onclick="campOption(this.value)" /> 좋아요많은순
						  			<br><br>
						  			<span>캠핑장유형별선택</span>
						  			<input type="radio" name="camp-option" onclick="campOption(this.value)" />카라반
						  			<input type="radio" name="camp-option" onclick="campOption(this.value)" />글램핑
						  			<input type="radio" name="camp-option" onclick="campOption(this.value)" />오토캠핑
						  			<input type="radio" name="camp-option" onclick="campOption(this.value)" />일반야영장
						  		</div>
						  </div>
						</div>

					</div>
				</div>
				
				<!-- 캠핑장 목록 출력  -->
				<div id="camp-list-container">
				
				</div>
			</div>
		</main>
	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.0/axios.min.js"></script>
	<script src="/resource/js/campSearch.js"></script>
	<script src="/resource/js/campToggle.js"></script>
	<script src="/resource/js/paging.js"></script>
</body>
</html>