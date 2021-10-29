<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<c:set var ="i" value="0"/>
	<c:set var ="j" value="5"/>
		
	<c:forEach items="${doNms}" var="doNms">
	<!--0부터 ul태그 열고 , 1,2,3,4 까지 li 출력 후 ul 태그가 닫힘   -->
		<c:if test="${i%j == 0}">
			<ul class="do-list">
		</c:if>	
				<li>
					<label class="box-radio-input">
						<input type="radio" class="do-nm" value="${doNms.DO_NM}"
							name="do-nm" onclick="getSigungu(this.value)"/>
						<span class="show-do-nm">${doNms.DO_NM}(${doNms.DO_COUNT})</span>
					</label>
				</li>
		<c:if test="${i%j == j-1}">
			</ul>
		</c:if>
		<c:set var="i" value="${i+1}"/>
	</c:forEach>
	