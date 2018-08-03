<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.travel.pak.dao.*,com.travel.pak.dto.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
<!-- <div class="fl_l">메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/>메뉴임<br/></div> -->
<% session.setAttribute("id","kkk"); 
   session.setAttribute("pass","kkk");
%>
<div class="wrapDiv">
	<table class="table table-hover">
		<tr><td colspan="5"><h2 style="text-align:center;">게시 글 리스트</h2></td></tr>
		<tr>
			<td colspan="5">
				<form name="searchForm" id="searchForm">
					<select name="type" id="type">						
						<option value="title">제목</option>
						<option value="writer">작성자</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="keyword" id="keyword" style="border:1px solid black;"/>
					<input type="submit" value="검색" />
				</form>
			</td>
		</tr>
		<c:if test="${ searchOption }">
		<tr>
			<td colspan="5" id="searchComment" style="board: 1px solid red">
				"${ word  }" 검색 결과</td>
		</tr>
		</c:if>
		<c:if test="${ not searchOption }">
		<tr>			
			<td colspan="5" class="listWrite"><a href="writeForm.mvc">글쓰기</a></td>
		</tr>
		</c:if>
		<c:if test="${ searchOption }">
		<tr>			
			<td colspan="2" class="boardListLink"><a href="travelList.mvc">리스트</a></td>
			<td colspan="3" class="listWrite"><a href="writeForm.mvc">글쓰기</a></td>
		</tr>
		</c:if>
		<tr>
			<th class="listThNo">NO</th>
			<th class="listThTitle">제목</th>
			<th class="listThWriter">작성자</th>
			<th class="listThRegDate">작성일</th>
			<th class="listThReadCount">조회수</th>
		</tr>
		<!-- 검색이고 내용물이 비어있지 않을 때 -->
	<c:if test="${ searchOption and not empty travelList }">
		<c:forEach var="t" items="${ travelList }" varStatus="status">		
		<tr class="listTr">
			<td class="listTdNo">${ t.no  }</td>
			<td class="listTdTitle">
				<a href="travelDetail.mvc?no=${ t.no }&pageNum=${ currentPage }&type=${ type }&keyword=${ keyword }">${ t.title }</a>
			</td>
			<td class="listTdWriter">${ t.writer }</td>
			<td class="listTdRegDate"><fmt:formatDate value="${ t.regDate }" 
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td class="listTdReadCount">${ t.readCount }</td> 
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" class="listPage" style="text-align:center;">
			 	<c:if test="${ startPage > pageGroup }">
					<a href="travelList.mvc?pageNum=${ startPage - pageGroup }&type=${ type }&keyword=${ keyword }">[이전]</a>
				</c:if>	
				<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
					<c:if test="${ i == currentPage }">
						[ ${ i } ]
					</c:if>			
					<c:if test="${ i != currentPage }">
						<a href="travelList.mvc?pageNum=${ i }&type=${ type }
							&keyword=${ keyword }">[ ${ i } ]</a>
					</c:if>			
				</c:forEach>
				<c:if test="${ endPage < pageCount }">
					<a href="travelList.mvc?pageNum=${ startPage + pageGroup }&type=${ type }&keyword=${ keyword }">[다음]</a>
				</c:if>		
			</td>
		</tr>
	</c:if>
	<c:if test="${ not searchOption and not empty travelList }">
		<c:forEach var="t" items="${ travelList }" varStatus="status">		
		<tr class="listTr">
			<td class="listTdNo">${ t.no  }</td>
			<td class="listTdTitle">
				<a href="travelDetail.mvc?no=${ t.no }&pageNum=${ currentPage }" >${ t.title }</a>
			</td>
			<td class="listTdWriter">${ t.writer }</td>
			<td class="listTdRegDate"><fmt:formatDate value="${ t.regDate }" 
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td class="listTdReadCount">${ t.readCount }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" class="listPage" style="text-align:center;">
			 	<c:if test="${ startPage > pageGroup }"> 
					<a href="travelList.mvc?pageNum=${ startPage - pageGroup }">
						[이전]</a>
				</c:if>	
				<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
					<c:if test="${ i == currentPage }">
						[ ${ i } ]
					</c:if>			
					<c:if test="${ i != currentPage }">
						<a href="travelList.mvc?pageNum=${ i }">[ ${ i } ]</a>
					</c:if>			
				</c:forEach>
				<c:if test="${ endPage < pageCount }">
					<a href="travelList.mvc?pageNum=${ startPage + pageGroup }">
						[다음]</a>
				</c:if>		
			</td>
		</tr>
	</c:if>
	<!-- 검색 요청이면서 검색된 리스트가 존재하지 않을 경우 -->
	<c:if test="${ searchOption and empty travelList }">
		<tr>
			<td colspan="5" class="listTdSpan">
				"${ keyword }"가 포함된 게시 글이 존재하지 않습니다.</td>
		</tr>
	</c:if>
	<!-- 일반 게시 글 리스트 요청이면서 게시 글 리스트가 존재하지 않을 경우 -->
	<c:if test="${ not searchOption and empty travelList }">
		<tr>
			<td colspan="5" class="listTdSpan">게시 글이 존재하지 않습니다.</td>
		</tr>
	</c:if>
	</table>
</div>
</article>