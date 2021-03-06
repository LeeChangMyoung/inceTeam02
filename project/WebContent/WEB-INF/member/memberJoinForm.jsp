<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<article>
	<div class="container">
		<div class="page-header">
			<h1 class="text-center"><strong>회원 가입</strong></h1>
		</div>
		
		<div class="col-md-6 col-md-offset-3">
			<form>
			<input type="hidden" 
				name="isIdCheck" id="isIdCheck" value="true"/>
		 	 <div class="form-group">
				<label for="inputId">아이디</label>
				<input type="text" class="form-control" placeholder="아이디 입력" 
					name="id" style="-webkit-ime-mode: disabled; -moz-ime-mode: disabled; 
						-ms-ime-mode: disabled; ime-mode: disabled;"
					value="${ sessionScope.pmember.id }"/>
			 </div>
			 <div class="form-group">
			 	<label for="inputPass">비밀번호</label>
			 	<input type="password" name="pass1" class="form-control" 
			 		pattern="[A-Za-z0-9]*" placeholder="비밀번호 입력" />
			 </div>
			 <div class="form-group">
			 	<label for="inputPass">비밀번호 확인</label>
			 	<input type="password" name="pass2" class="form-control" 
			 		placeholder="비밀번호 확인">
			 	<p class="help-block">*비밀번호 확인을 위해 한번 더 입력 해 주세요</p>
			 </div>
			 <div class="form-group">
             	<label for="username">이름</label>
             	<input type="text" name="name" class="form-control" id="username" 
             		style="ime-mode: active" placeholder="이름을 입력해 주세요"
             		value="${ sessionScope.pmember.name }" />
             	<p class="help-block">*반드시 실명으로 입력 해 주세요</p>
             </div>
             <div class="form-group">
              	<label for="inputEmail">이메일</label>
              	<input type="email" class="form-control" placeholder="example@gmail.com">
             </div>
             <div class="form-group">
             	<label for="inputPhon">핸드폰번호</label>
				<div class="input-group">
					<input type="tel" class="form-control"  placeholder="-없이 입력해 주세요">
					<span class="input-group-btn">
						<button class="btn btn-primary">인증번호 전송</button>
					</span>	
				</div>             	
             </div>
             <div class="form-group">
              <label for="username">인증번호 확인</label>
              <div class="input-group">
                <input type="text" class="form-control"  placeholder="본인 핸드폰으로 전송된 번호 입력">
                <span class="input-group-btn">
                  <button class="btn btn-primary">인증번호 입력<i class="fa fa-edit spaceLeft"></i></button>
                </span>
              </div>
            </div>
            
            <div class="form-group">
              <label>약관 동의</label>
              <div data-toggle="buttons">
                  <input type="checkbox" >
	              <a href="#">이용약관</a>에 동의합니다.
              </div>
            </div>
            <div class="form-group ">
             <div class="col-sm-12 text-right">
              <button type="submit" class="btn btn-success">회원가입</button>
              <button type="submit" class="btn btn-danger">취 소</button>
             </div>
            </div>
            
             
			</form>
		</div>
	</div>
</article>