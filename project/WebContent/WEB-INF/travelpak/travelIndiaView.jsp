<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<article>
 
	<div id="band" class="container text-center" style="width:100%">
	<h2 id ="tpaklist">인도 상품 리스트</h2>  
	
	<%@ include file="../pages/sidebar.jsp" %>
	<c:forEach var ="t" items="${ travelList }" varStatus ="status">
	   <div id="tpakfloat">
		   <div id = product>
		   
		  	<ul class="product_list">
		  		<li><a href="travelDetail.mvc?no=${t.pak_code}">
		  		<span class="pic"><img src="${t.pak_image }"></span>
		  		<p><strong>${ t.pak_title }</strong></p>
		  		</a></li>
		  		
		  		<p id="tpakprice"> ${t.pak_price }</p>
		  		
		  		 
		  	</ul>
		  	</div>
	    </div>
	</c:forEach>
	
	</div>

	
</article>