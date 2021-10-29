<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.work.wecamp.camp.dto.Campsite" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
﻿<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>﻿
<title>리뷰작성</title>
<style type="text/css"> 
 div#fcl fieldset{
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    direction: rtl; /* 이모지 순서 반전 */
    border: 0; /* 필드셋 테두리 제거 */
}
div#fcl fieldset legend{
    text-align: left;
}
div#fcl input[type=radio]{
    display: none; /* 라디오박스 감춤 */
}
div#fcl label{
    font-size: 2em; /* 이모지 크기 */
    color: transparent; /* 기존 이모지 컬러 제거 */
    text-shadow: 0 0 0 #f0f0f0; /* 새 이모지 색상 부여 */
}
div#fcl label:hover{
    text-shadow: 0 0 0 #FFBF00; /* 마우스 호버 */
}
div#fcl label:hover ~ label{
    text-shadow: 0 0 0 #FFBF00; /* 마우스 호버 뒤에오는 이모지들 */
}

div#fcl input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 #FFBF00; /* 마우스 클릭 체크 */
}

/*-------------------------*/
 div#env fieldset{
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    direction: rtl; /* 이모지 순서 반전 */
    border: 0; /* 필드셋 테두리 제거 */
}
div#env fieldset legend{
    text-align: left;
}
div#env input[type=radio]{
    display: none; /* 라디오박스 감춤 */
}
div#env label{
    font-size: 2em; /* 이모지 크기 */
    color: transparent; /* 기존 이모지 컬러 제거 */
    text-shadow: 0 0 0 #f0f0f0; /* 새 이모지 색상 부여 */
}
div#env label:hover{
    text-shadow: 0 0 0 #FFBF00; /* 마우스 호버 */
}
div#env label:hover ~ label{
    text-shadow: 0 0 0 #FFBF00; /* 마우스 호버 뒤에오는 이모지들 */
}

div#env input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 #FFBF00; /* 마우스 클릭 체크 */
}

/*-------------------------*/
 div#ser fieldset{
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    direction: rtl; /* 이모지 순서 반전 */
    border: 0; /* 필드셋 테두리 제거 */
}
div#ser fieldset legend{
    text-align: left;
}
div#ser input[type=radio]{
    display: none; /* 라디오박스 감춤 */
}
div#ser label{
    font-size: 2em; /* 이모지 크기 */
    color: transparent; /* 기존 이모지 컬러 제거 */
    text-shadow: 0 0 0 #f0f0f0; /* 새 이모지 색상 부여 */
}
div#ser label:hover{
    text-shadow: 0 0 0 #FFBF00; /* 마우스 호버 */
}
div#ser label:hover ~ label{
    text-shadow: 0 0 0 #FFBF00; /* 마우스 호버 뒤에오는 이모지들 */
}

div#ser input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 #FFBF00; /* 마우스 클릭 체크 */
}
</style>  

</head>
<body> 

<form action="reviewWrite">
	내용 : <input type="text" name="content"></br>
	캠핑장번호 : <input type="text" name="campsiteNo" value="${no}" readonly="readonly"></br>
	시설별점 :  
	<div class="fcl" id="fcl">
	<fieldset name="fclRating"> 
        <input type="radio" name="fclRating" value="5" id="fcl_rate1"><label for="fcl_rate1">⭐</label>
        <input type="radio" name="fclRating" value="4" id="fcl_rate2"><label for="fcl_rate2">⭐</label>
        <input type="radio" name="fclRating" value="3" id="fcl_rate3"><label for="fcl_rate3">⭐</label>
        <input type="radio" name="fclRating" value="2" id="fcl_rate4"><label for="fcl_rate4">⭐</label>
        <input type="radio" name="fclRating" value="1" id="fcl_rate5"><label for="fcl_rate5">⭐</label>
    </fieldset></br>
    </div>
	환경별점 :
	<div class="env" id="env">
	<fieldset name="envRating"> 
        <input type="radio" name="envRating" value="5" id="env_rate1"><label for="env_rate1">⭐</label>
        <input type="radio" name="envRating" value="4" id="env_rate2"><label for="env_rate2">⭐</label>
        <input type="radio" name="envRating" value="3" id="env_rate3"><label for="env_rate3">⭐</label>
        <input type="radio" name="envRating" value="2" id="env_rate4"><label for="env_rate4">⭐</label>
        <input type="radio" name="envRating" value="1" id="env_rate5"><label for="env_rate5">⭐</label>
    </fieldset></br>
    </div>
	서비스별점 : 
	<div class="ser" id="ser">
    <fieldset name="serviceRating"> 
        <input type="radio" name="serviceRating" value="5" id="service_rate1"><label for="service_rate1">⭐</label>
        <input type="radio" name="serviceRating" value="4" id="service_rate2"><label for="service_rate2">⭐</label>
        <input type="radio" name="serviceRating" value="3" id="service_rate3"><label for="service_rate3">⭐</label>
        <input type="radio" name="serviceRating" value="2" id="service_rate4"><label for="service_rate4">⭐</label>
        <input type="radio" name="serviceRating" value="1" id="service_rate5"><label for="service_rate5">⭐</label>
    </fieldset></br>
    </div>
	<input type="submit" value="등록">
	 
</form>
</body>
</html>