<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.detail_pak{
	position: relative;
	width:1200px ;
   	height: 358px;
   	margin: auto;
   	border-top: 1px solid #d1d4d6;
   	letter-spacing: -1px;
}
ol, ul {
    list-style: none;
 }
.detail_pak .detail_info {
	float: left;
    width: 630px;
    margin: 16px 0 0 0;
	}
	
.detail_pak .detail_info li {	
	position: relative;
    display: inline-block;
    width: 100%;
    padding: 11px 0 17px 0;
}	

.detail_pak .detail_info li span.p_title{
	width: 115px;
    margin-top: 4px;
} 
.detail_pak .detail_info li span.p_txt{
	font-size: 18px;
    color: #303030;
    font-weight: 600;
}

/* 이미지 화면 */

.detail_pak .detail_img{
    float: right;
    position: relative;
    width: 410px;
    height: 318px;
    margin: 24px 0 0 0;
}	

</style>

<c:set var="detail" value="${ pakDetail }" />

<div class="detail_pak">
	<h2>${detail.pak_title}</h2>	

	<ul class=detail_info>
	  <li>
		<span class="p_title" > 상품가격 </span>
		<span class="p_txt"> ${detail.pak_price} </span>
	  </li>  
	  <li>
		<span class="p_title"> 여행기간</span>
		<span class="p_txt"> ${detail.pak_during_date} </span>
	  </li>
	  <li>
		<span class="p_title"> 상품 설명</span>
		<span class="p_txt"> ${detail.pak_detail}</span>
	  </li>  
	</ul>
	
	<div class="detail_img" > 
		<img src="${detail.pak_image}" /> 
	</div>
	
	
	
</div>
	<table class="table">
	<tr>
		<td id="tdsmall" class ="tline">출/도착 시간</td>
		<td class ="tline">상품명</td>
		<td class ="tline">여행기간</td>
		<td class ="tline">상품가격</td>
		<td class ="tline">결제</td>
	</tr>
	<tr>
		<td id="tdsmall">출발/도착 기간</td>
		<td id="tpname">상품명</td>
		
		<td id="tp">여행기간</td>
		<td>상품가격</td>
		<td><button type="button" class="btn btn-success">결제</button></td>
	</tr>
</table>
