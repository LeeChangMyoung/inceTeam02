<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<article>
 
<c:forEach var ="t" items="${ travelList }" varStatus ="status">
	<div id="band" class="container text-center" style="width:100%;">
	<h2>일본 상품 리스트</h2>  
   	<div id = product>
  	  <ul class="product_list">
  		<li><a href="#"><span class="pic"><img src="${t.pak_image }"></span><p><strong>${ t.pak_title }</strong></p></a></li>
  		<li><a href="#"><span class="pic"><img src="images/ehzy.jpg"></span><p></p></a></li>
  		<li><a href="#"><span class="pic"><img src="images/ehzy.jpg"></span></a></li>
  		<li><a href="#"><span class="pic"><img src="images/ehzy.jpg"></span></a></li>
  		<li><a href="#"><span class="pic"><img src="images/ehzy.jpg"></span></a></li>
  	  </ul>
    </div>
    </div>
</c:forEach> 
	
<article>