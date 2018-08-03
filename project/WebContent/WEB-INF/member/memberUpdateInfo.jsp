<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article>
	<div id="memberJoinForm">
	<h3 id="joinFormTitle">회원 정보 수정 확인</h3>
	<c:set var="pmember" value="${ requestScope.pmember }" scope="session" />
		<div id="memberInputDefault">			
			<div class="memberInputText">
				<span class="memberSpan">* 이&nbsp;&nbsp;름 : </span>
				<span class="inputInfoSpan">${ pmember.name }</span></div>
			<div class="memberInputText">
				<span class="memberSpan">* 아이디 : </span>
				<span class="inputInfoSpan">${ pmember.id }</span></div>
			<div class="memberInputText">
				<span class="memberSpan">* 비밀번호 : </span>
				<span class="inputInfoSpan">${ pmember.pass }</span></div>
			<div class="memberInputText">
				<span class="memberSpan">* 우편번호 : </span>
				<span class="inputInfoSpan">${ pmember.zipcode }</span></div>
			<div class="memberInputText">
				<span class="memberSpan">* 자택주소 : </span>
				<span class="inputInfoSpan">${ pmember.addr1 }</span></div>
			<div class="memberInputText">
				<span class="memberSpan">상세주소 : </span>
				<span class="inputInfoSpan">${ pmember.addr2 }</span></div>
			<div class="memberInputText">
				<span class="memberSpan">* 이 메 일 : </span>
				<span class="inputInfoSpan">${ pmember.email }</span></div>
			<div class="memberInputText">
				<span class="memberSpan">* 휴 대 폰 : </span>
				<span class="inputInfoSpan">${ pmember.mobile }</span></div>
		</div>
		<div class="formButton">
			<input type="button" value="수정하기"
				onclick="document.location.href='memberUpdateForm.mvc'"/>
			<input type="submit" value="수정완료" 
				onclick="document.location.href='memberUpdateResult.mvc'"/></div>						
	</div>	
</article>