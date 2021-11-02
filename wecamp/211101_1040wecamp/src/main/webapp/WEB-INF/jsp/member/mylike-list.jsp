<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.work.wecamp.member.controller.MemberController" %>
<%@ page import="com.work.wecamp.member.model.Member" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<style>
.camp-img-box{
	width: 30%;
}
</style>
<body>
 
<c:forEach  var="r" items="${campList}">
 	
		
			<c:choose>
				<c:when test="${empty r.thumbnail}">
					<div class="camp-img-box" style="background-image: url('https://gocamping.or.kr/upload/camp/6764/thumb/thumb_720_3462IXfFkJ3mBey7bbrXyHsv.jpg')">
				<img src="${r.thumbnail}"> 
					</div>
				</c:when>
				
				<c:otherwise>
					<img src="${r.thumbnail}"> 
				
				</c:otherwise>
			</c:choose>
			
			<div class="camp-info">	
				<div class="camp-title">${r.facltNm}</div>
				<div class="camp-intro">${r.lineIntro}</div>
				<div class="camp-addr">${r.addr1}</div>
				<div class="camp-tel">${r.tel}</div>
				<input type="hidden" value="${r.lat}" id="lat"/>
				<input type="hidden" value="${r.lon}" id="lon"/>
				<input type="hidden" value="${r.campsiteNo}" id="campsite-no"/>
				<input type="hidden" value="${r.induty}" id="induty"/>
				<input type="hidden" value="${r.animalCmg}"/>
			</div>
		
</c:forEach>

	
</body>
</html>