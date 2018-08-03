<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article>
<script src="js/formcheck.js"></script>

<form name="updateForm" id="updateForm" action="updateProcess.mvc"
	method="post" 
	${ not empty travel.file ?  "" : "enctype='multipart/form-data'"}>
	<!--
		no는 DB에서 게시 글을 수정하기 위해 필요하고 pageNum은 게시 글이 
		수정된 후에 이전에 사용자가 머물렀던 게시 글 리S스트의 동일한 페이지로
		보내기 위해 필요한 정보이다.  
	-->
	<input type="hidden" name="no" value="${ travel.no }" />
	<input type="hidden" name="pageNum" value="${ pageNum }" />
	<!-- 
		검색 요청일 경우 다시 keyword에 해당하는 검색 리스트로
		돌려보내기 위해서 아래의 파라미터가 필요하다.
	 -->
	<c:if test="${ searchOption }">
		<input type="hidden" name="type" value="${ type }" />
		<input type="hidden" name="keyword" value="${ keyword }" />
	</c:if>	
<div class="updateDiv">	
<table class="contentTable table table-hover">
	<tr>
		<td colspan="4" class="travelTitle"><h2>게시 글 수정하기</h2></td>
	</tr>
	<tr><td colspan="4">&nbsp;</td></tr>
	<tr class="tr1">
		<th class="readTh">글쓴이</th>
		<td class="readTd">
			<input type="text" name="writer" id="writer" size="30" 
				maxlength="10" value="${ travel.writer }"/>
		</td>
		<th class="readTh1">비밀번호</th>
		<td class="readTd1">
			<input type="password" name="pass" id="pass" size="30" 
				maxlength="10" />
		</td>
	</tr>
	<tr>
		<th class="readTh">제&nbsp;&nbsp;목</th>
		<td class="readTd" colspan="3">
			<input type="text" name="title" id="title" size="50" 
				maxlength="50" style="width:251px;"value="${ travel.title }"/>
		</td>				
	</tr>
	<tr>
		<th class="readTh">내&nbsp;&nbsp;용</th>
		<td class="readTd" colspan="3">
			<textarea name="content" id="content" rows="20" 
				cols="72" style="width:650px;">${ travel.content } </textarea>
		</td>				
	</tr>
	<tr>
		<th class="readTh" style="letter-spacing: 7px;">파일첨부</th>
		<td class="readTd" colspan="3">
			<input type="file" name="file" id="file" size="50" style="width:649px;" 
				${ empty travel.file ? "" : "disabled" } />
		</td>				
	</tr>
	<tr>		
		<td class="tdSpan" colspan="4" style="text-align:center;">
			<input type="reset" value="다시쓰기" />
			&nbsp;&nbsp;<input type="submit" value="수정하기" />
			<!-- 일반 게시 글 리스트에서 온 요청이면 일반 게시 글 리스트로 돌려보낸다. -->
			<c:if test="${ not searchOption }">		
				&nbsp;&nbsp;<input type="button" value="목록보기" 
					onclick="javascript:window.location.href='travelList.mvc?pageNum=${ pageNum }'"/>
			</c:if>
			<!-- 검색 리스트에서 온 요청이면 검색 리스트의 동일한 페이지로 돌려보낸다. -->
			<c:if test="${ searchOption }">
				&nbsp;&nbsp;<input type="button" value="목록보기" 
					onclick="javascript:window.location.href='travelList.mvc?pageNum=${ pageNum }&type=${ type }&keyword=${ keyword }'"/>
			
			</c:if>				
		</td>
	</tr>
</table>
</div>
</form>			
</article>