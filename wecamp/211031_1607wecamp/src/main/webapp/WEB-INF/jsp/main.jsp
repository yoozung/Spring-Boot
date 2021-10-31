<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.work.wecamp.member.controller.MemberController" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/main.css"> 
    <link rel="stylesheet" href="/css/normal.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
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
<!-- 
	<c:choose>
		<c:when test="${empty memberId}">
		 
  
     
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
	</c:choose>-->

	 <header id="header">
        
        <a href="" class="logo">
            <i class="fal fa-campground"></i>
            wecamp
        </a>

        <ul>
            <li><a href="#" class="active">Home</a></li>
            <li><a href="#" >About</a></li>
            <li><a href="#">List</a></li>
            <li><a href="#">Contact</a></li>
            <li> </li>
        </ul>
    </header>	

    <section id="background-container">
        <div class="img-box">
            <div class="text">
                우리가 찾던 모든 캠핑장
            </div>  
            <div class="search">
                <span>
                    WECAMP
                </span>
            </div> 
        </div>
    </section>

	<div class="camping-type-ment">Camping Type</div>

	<div class="camping-type-box">
		<table class="camping-type-table">
			<tr>

				<td class="food-card"><div class="overlay">카라반</div> <a
					href="#" target="_blank"><img class="food-image"
						src="https://images.unsplash.com/photo-1566847838496-c670dd0ec05e?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Y2FyYXZhbnxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60" /></a></td>
				<td class="food-card"><div class="overlay">일반야영장</div> <a
					href="#" target="_blank"><img class="food-image"
						src="https://images.unsplash.com/photo-1487730116645-74489c95b41b?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGNhbXBpbmd8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60" /></a></td>

				<td class="food-card"><div class="overlay">글램핑</div> <a
					href="#" target="_blank"><img class="food-image"
						src="https://images.unsplash.com/photo-1541004995602-b3e898709909?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjB8fGdsYW1waW5nfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60" /></a></td>
				<td class="food-card">
					<div class="overlay">오토캠핑</div> <a href="#" target="_blank"> <img
						class="food-image"
						src="https://media.istockphoto.com/photos/camping-under-the-night-sky-picture-id1285665871?b=1&k=20&m=1285665871&s=170667a&w=0&h=1odiNLYhFRArpVbmGZAvgCm_28LUrD0JDAf2WrIUXjw=" />
				</a>
				</td>
			<tr>
		</table>
	</div>
	
	
	<div class="carousel-king">
	<div class="carousel-semiking">
	<div class="carousel-type-ment">Editor's Pick</div>

<div class="carousel-box">
<div class="inner">
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/img/pet.png" id="carousel-img" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/img/pet2.png" id="carousel-img" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/img/main_image.jpg" id="carousel-img" class="d-block w-100" alt="...">
    </div>
  </div>
 <button class="carousel-control-prev" type="button" data-target="#carouselExampleControls" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-target="#carouselExampleControls" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </button>
</div>
</div>
</div>
</div>
</div>

</body>
</html>