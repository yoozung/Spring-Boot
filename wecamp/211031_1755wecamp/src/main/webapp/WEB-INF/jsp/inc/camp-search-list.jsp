<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var ="i" value="0"/>
<c:set var ="j" value="3"/>

<!-- 한줄에 3개 출력 -->
<c:forEach items="${campList}" var="campList">
	<c:if test="${i%j == 0}">
		<div class="camp-inner">
	</c:if>		
		
		<div class="campsite-list" onclick="detail(${campList.CAMPSITE_NO})">
			<c:choose>
				<c:when test="${empty campList.THUMBNAIL}">
					<div class="camp-img-box" style="background-image: url('https://gocamping.or.kr/upload/camp/6764/thumb/thumb_720_3462IXfFkJ3mBey7bbrXyHsv.jpg')">
				
					</div>
				</c:when>
				
				<c:otherwise>
					<div class="camp-img-box" style="background-image: url('${campList.THUMBNAIL}')">
				
					</div>
				</c:otherwise>
			</c:choose>
			
			<div class="camp-info">	
				<div class="camp-title">${campList.FACLT_NM}</div>
				<div class="camp-intro">${campList.LINE_INTRO}</div>
				<div class="camp-addr">${campList.ADDR1}</div>
				<div class="camp-tel">${campList.TEL}</div>
				<input type="hidden" value="${campList.LAT}" id="lat"/>
				<input type="hidden" value="${campList.LAT}" id="lon"/>
				<input type="hidden" value="${campList.CAMPSITE_NO}" id="campsite-no"/>
				<input type="hidden" value="${campList.INDUTY}" id="induty"/>
				<input type="hidden" value="${campList.ANIMAL_CMG}"/>
			</div>
		</div>
		
	<c:if test="${i%j == j-1}">	
		</div>
	</c:if>
	<c:set var="i" value="${i+1}"/>
</c:forEach>

<!-- 페이징 박스 -->	

<c:if test="${not empty paging}">
	<div class="paging-box">
			<c:if test="${paging.startPage > 1}">
				<span id="first-page" onclick="selectPage(1)">처음</span>
			</c:if>
			<c:if test="${paging.page > 1}">
				<span id="prev-page" onclick="selectPage(${paging.page-1})">이전</span>
			</c:if>
			<c:forEach var = "i" begin="${paging.startPage}" end="${paging.endPage}">
				<c:choose>
					<c:when test="${i == paging.page}">
						<span id="current-page">${i}</span>
					</c:when>
					<c:otherwise>
						<span class="select-page" onclick="selectPage(this.textContent)">${i}</span>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		
			<c:if test="${paging.page < paging.totalPage}">
				<span id="next-page" onclick="selectPage(${paging.page + 1})">다음</span>
			</c:if>
			
			<c:if test="${paging.endPage < paging.totalPage}"> 
				<span id="end-page" onclick="selectPage(${paging.totalPage})">끝</span>
			</c:if>
	</div>
</c:if>



