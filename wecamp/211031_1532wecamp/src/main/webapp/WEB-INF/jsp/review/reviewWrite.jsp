<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.work.wecamp.camp.dto.Campsite" %>
    <%@ page import="com.work.wecamp.review.controller.ReviewController" %>
    <%@ page import="com.work.wecamp.member.model.Member" %>
    <%@ include file="../inc/Taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">﻿
<title>리뷰작성</title>
<link type="text/css" rel="stylesheet"
	href="/css/review/reviewWrite.css">
</head>
<body class="body"> 
<%
   Member dto = (Member)request.getAttribute("dto");
   
%>


<div class="first-body">


<form action="reviewWrite">
<div class="second-body">
	<div class="column-box"><span class="review-column">내용</span><input type="text" name="content" id="content"></div></br>
	<div class="column-box"><span class="review-column">캠핑장번호</span> <input type="text" name="campsiteNo" id="campsiteNo" value="${no}" readonly="readonly"></br>
	<div class="column-box"><span class="review-column">멤버번호</span> <input type="text" name="memberNo"   readonly="readonly" value="${dto.member_no}"></br>
	</div>
	<div class="star-box">
	<span class="review-column-star">시설별점 </span>
	<div class="fcl" id="fcl">
	<fieldset name="fclRating"> 
        <input type="radio" name="fclRating" value="5" id="fcl_rate1"><label for="fcl_rate1">⭐</label>
        <input type="radio" name="fclRating" value="4" id="fcl_rate2"><label for="fcl_rate2">⭐</label>
        <input type="radio" name="fclRating" value="3" id="fcl_rate3"><label for="fcl_rate3">⭐</label>
        <input type="radio" name="fclRating" value="2" id="fcl_rate4"><label for="fcl_rate4">⭐</label>
        <input type="radio" name="fclRating" value="1" id="fcl_rate5"><label for="fcl_rate5">⭐</label>
    </fieldset></br>
    </div>
    </div>
    
    <div class="star-box">
	<span class="review-column-star">환경별점</span>
	<div class="env" id="env">
	<fieldset name="envRating"> 
        <input type="radio" name="envRating" value="5" id="env_rate1"><label for="env_rate1">⭐</label>
        <input type="radio" name="envRating" value="4" id="env_rate2"><label for="env_rate2">⭐</label>
        <input type="radio" name="envRating" value="3" id="env_rate3"><label for="env_rate3">⭐</label>
        <input type="radio" name="envRating" value="2" id="env_rate4"><label for="env_rate4">⭐</label>
        <input type="radio" name="envRating" value="1" id="env_rate5"><label for="env_rate5">⭐</label>
    </fieldset></br>
    </div>
    </div>
    
    <div class="star-box">
	<span class="review-column-star">서비스별점</span>
	<div class="ser" id="ser">
    <fieldset name="serviceRating"> 
        <input type="radio" name="serviceRating" value="5" id="service_rate1"><label for="service_rate1">⭐</label>
        <input type="radio" name="serviceRating" value="4" id="service_rate2"><label for="service_rate2">⭐</label>
        <input type="radio" name="serviceRating" value="3" id="service_rate3"><label for="service_rate3">⭐</label>
        <input type="radio" name="serviceRating" value="2" id="service_rate4"><label for="service_rate4">⭐</label>
        <input type="radio" name="serviceRating" value="1" id="service_rate5"><label for="service_rate5">⭐</label>
    </fieldset></br>
    </div>
    </div>
    </div>
	<input type="submit" value="등록" id="submit-btn">
	
</form>
</div> 

</body>
</html>