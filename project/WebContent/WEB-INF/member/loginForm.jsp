<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<style>

	
</style>


<article>
	<form action="login.mvc" id="formLogin"
				name="loginForm" method="post">
				<div id="loginInput">
					<input type="hidden" name="currentURL" id="loginURL"/>
					<input type="text" name="id" id="inputId"/><br/>
					<input type="password" name="pass" id="inputPass"/>
				</div>			
				<input type="image" src="images/btn_login.png" id="btnLogin" />
			</form>
</article>