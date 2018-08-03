<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<article>
	<div id="memberJoinForm">
	<h3 id="joinFormTitle">회원 정보 입력</h3>
	<form action="joinInfo.mvc" name="joinForm" method="post"
		id="joinForm">
		
		<input type="hidden" name="isIdCheck" id="isIdCheck" value="true"/>
		<div id="memberInputDefault">
			<div class="memberInputText">
				<span class="memberSpan">* 이&nbsp;&nbsp;름 : </span>
				<input type="text" name="name" size="15" style="ime-mode: active"
					id="name" value="${ sessionScope.pmember.name }" />
			</div>
			<div class="memberInputText">
				<span class="memberSpan">* 아이디 : </span>
				<input type="text" name="id" size="15"  id="userId"
					style="-webkit-ime-mode: disabled; -moz-ime-mode: disabled; 
						-ms-ime-mode: disabled; ime-mode: disabled;"
					value="${ sessionScope.pmember.id }"/>
				<input type="button" value="중복확인" id="btnOverlapId"/>
			</div>
			<div class="memberInputText">
				<span class="memberSpan">* 비밀번호 : </span>
				<input type="password" name="pass1" id="pass1" 
					pattern="[A-Za-z0-9]*" class="imeMode" size="15"/>
			</div>
			<div class="memberInputText">
				<span class="memberSpan">* 비밀번호 확인 : </span>
				<input type="password" name="pass2" id="pass2" size="15"/>
			</div>
			<div class="memberInputText">
				<span class="memberSpan">* 우편번호 : </span>
				<input type="text" name="zipcode" size="6" 
					maxlength="5"  id="zipcode"
					value="${ sessionScope.pmember.zipcode }"/>&nbsp;
				<input type="button" value="우편번호 검색" id="btnZipcode"/>
			</div>
			<div class="memberInputText">
				<span class="memberSpan">* 자택주소 : </span>
				<input type="text" name="address1" size="60"  id="address1" 
					value="${ sessionScope.pmember.addr1 }"/>
			</div>
			<div class="memberInputText">
				<span class="memberSpan">상세주소 : </span>
				<input type="text" name="address2" size="60" id="address2" 
					value="${ sessionScope.pmember.addr2 }"/>
			</div>
			<div class="memberInputText">
				<span class="memberSpan">* 이 메 일 : </span>
				<input type="text" name="emailId" size="10" id="emailId"
					class="imeMode" value="${ sessionScope.pmember.email.split('@')[0] }"/>
				@ <input type="text" name="emailDomain" size="10" id="emailDomain" 					
					class="imeMode" value="${ sessionScope.pmember.email.split('@')[1] }"/>
				<select name="selectDomain" id="selectDomain">
					<option>직접입력</option>
					<option>네이버</option>
					<option>다음</option>
					<option>한메일</option>
					<option>구글</option>										
				</select>
			</div>
			<div class="memberInputText">
				<span class="memberSpan">* 휴 대 폰 : </span>
				<select name="mobile1" id="mobile1">
					<option ${ pmember.mobile.split('-')[0] == 010 ? "selected" : "" }>
						010</option>
					<option ${ pmember.mobile.split('-')[0] == 011 ? "selected" : "" }>
						011</option>
					<option ${ pmember.mobile.split('-')[0] == 016 ? "selected" : "" }>
						016</option>
					<option ${ pmember.mobile.split('-')[0] == 017 ? "selected" : "" }>
						017</option>
					<option ${ pmember.mobile.split('-')[0] == 018 ? "selected" : "" }>
						018</option>
					<option ${ pmember.mobile.split('-')[0] == 019 ? "selected" : "" }>
						019</option>
				</select>-					
				<input type="text" name="mobile2" size="3" maxlength="4" id="mobile2"
					value="${ sessionScope.pmember.mobile.split('-')[1] }"/>-
				<input type="text" name="mobile3" size="3" maxlength="4" id="mobile3"
					value="${ sessionScope.pmember.mobile.split('-')[2] }"/>
			</div>
		</div>
		<div class="formButton">
			<input type="reset" value="다시쓰기"/>
			<input type="submit" value="가입하기" />
		</div>
			
	</form>
	</div>
</article>