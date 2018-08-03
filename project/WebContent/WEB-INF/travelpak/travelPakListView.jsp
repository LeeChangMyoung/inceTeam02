<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<article>
	
	<style> 
	 #mainList1
	 {
	 	both:clear;
	 	border:1px solid red;
	 	height: 500px;
	 }
	 /* 패키지 화면 css  */
	 .main_pklist1{
	    position: relative;
    	width: 1200px;
    	margin: 0 auto;
	 }
	 
	 .package{
	 	float:left;
	  	both:clear;
	 	margin-top:30px; 
	 }
	 
	 .package_list{
	 	overflow: hidden;
    	margin-left: -20px;
    	list-style: none;
	 }
	 .package_list>li{
	 	float: left;
    	position: relative;
    	margin-left: 20px;
	 }
	 
	 .package_list>li>a{
	 	display: block;
    	width: 260px;
    	height: 300px;
    	padding: 18px;
    	border: 1px solid #A6A6A6;
	 }
	 .package_list>li>a .pic{
	 	overflow: hidden;
    	position: absolute;
    	left: 0;
    	top: 0;
    	width: 260px;
    	height: 170px;
	 }
	 .package_list>li>a img{
    	width: 260px;
    	height: 170px;
	 }
	 .package_list>li>a p{
	 	padding: 170px 0 18px 0;
    	color: #000;
    	font-size: 16px;
    	font-family: 'NanumBold';
    	line-height: 20px;
	 }
	 .package_list>li>a .price{
	 	float: right;
    	font-size: 16px;
    	/* color: #2312c; */
    	color: red;
    	font-family: 'NanumBold';
    	line-height: 20px;
	 }
	 .package_list {
	 	overflow: hidden;
    	margin-left: -25px;
    	list-style: none;
	 }
	 
	</style> 

   <div class = "main_pklist1">
  	<h2 class=text-center> 메 인 상 품 리 스 트</h2>
 	 
     <c:forEach var="pk" begin="1" end ="4" step="1" items="${pakList}" varStatus="status">
		<div class = "package">
			<ul class="package_list">
				<li><a href="#"><span class="pic"><img src="${pk.pak_image}"></span>
	 				<p> ${pk.pak_title} </p>
		     		<span class="price">${pk.pak_price}</span>
		     		</a>
				</li>
			</ul>
		</div>
	  </c:forEach>
 	 
     <c:forEach var="pk" begin="1" end ="4" step="1" items="${pakList}" varStatus="status">
		<div class = "package">
			<ul class="package_list">
				<li><a href="#"><span class="pic"><img src="${pk.pak_image}"></span>
	 				<p>	<strong>${pk.pak_title}</strong></p></a>
		     		${pk.pak_price}
				</li>
			</ul>
		</div>
	  </c:forEach>
	  
`

	 
	 </div>
</article>
