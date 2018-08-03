<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="js/formcheck.js?ver=4"></script>    
<article>
	<form name="writeForm" action="writeProcess.mvc" id="writeForm" 
		method="post" enctype="multipart/form-data">
		<br/><br/><br/>
 <div class="writeForm">
      <div class="writeWrap">
        <div class="title">
          게시 글쓰기
        </div>
        <div class="writeContents">
          <div class="ipSec wt01">
            <div class="letter_3">글쓴이</div>
            <input type="text" name="writer" class="test" id="writer">
          </div>
          <div class="ipSec wt02">
            <div class="letter_3">비밀번호</div>
            <input type="password" name="pass" id="pass" maxlength="10"/>
          </div>
          <div class="ipSec wt03">
            <div class="letter_2">제목</div>
            <input type="text" name="title" size="90" id="title"/>
          </div>
          <div class="ipSec wt04">
            <div class="letter_2">내용</div>
            <div class="textAreaBox">
              <textarea name="content" id="content" rows="20" cols="80" id="content"></textarea>
            </div>
          </div>
        </div>
        <div class="wt05 fileReg">
          <div>파일첨부</div>
          <input type="file" name="file" size="70" id="file" maxlength="50"/>
        </div>
        <div class="btnsWrap">
          <ul>
            <li>
              <input type="reset" value="다시쓰기"/>
            </li>
            <li>
              <input type="submit" value="등록하기" />
            </li>
            <li>
              <input type="button" value="목록보기" onclick="javascript:window.location.href='travelList.mvc'"/>
            </li>
          </ul>
        </div>
      </div>
    </div>
	</form>
</article>