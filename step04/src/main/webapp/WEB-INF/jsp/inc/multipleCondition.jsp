<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 다중조건검색 조각페이지 : inc/multipleCondition.jsp  -->

<div>
<<form action="multipleCondition" method="get">
	<select name='search'>
		<option value='' selected>-- 선택 --</option>
		<option value='apple'>아이디</option>
		<option value='banana'>등급</option>
		<option value='lemon'>마일리지</option>
		<option value='lemon'>담당자</option>
		<option value='lemon'>휴대폰</option>
		<option value='lemon'>이름</option>
		<option value='lemon'>이메일</option>
		<option value='lemon'>아이디+이메일</option>
	</select> <input type="text" value="검색어를 입력해주세요"> <input type="submit"
		value="검색">
		</form>
</div>



