<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<header>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="*.mvc">팀명</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right" style="float: right!important; width: 713px;margin-right: -15px;">

		<c:if test="${not sessionScope.isLogin }">
          <li><a href="loginForm.mvc">로그인</a></li>
          <li><a href="joinForm.mvc">회원가입</a></li>
        </c:if>
        <c:if test="${sessionScope.isLogin }">
          <li><a href="logout.mvc">로그아웃</a></li>
          <li><a href="memberUpdateForm.mvc">회원정보 수정</a></li>
        </c:if>

        <li><a href="reservation.mvc">마이페이지</a></li>
        <li><a href="#">예약확인/결제</a></li>
        <li><a href="#">고객센터</a></li>
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">전체상품
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">패키지상품</a></li>
            <li><a href="#">국내여행</a></li>
            <li><a href="#">해외여행</a></li> 
          </ul>
        </li>
        <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
      </ul>
    </div>
  </div>
</nav>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="images/ehzy.jpg" alt="New York" style="max-width: 100%; height: 500px">
        <div class="carousel-caption">
          <h3>도쿄</h3>
          <p><strong>여기는 도쿄 입니다...!</strong></p>
        </div>      
      </div>

      <div class="item">
        <img src="images/benis.jpg" alt="New York" style="max-width: 100%; height: 500px">
        <div class="carousel-caption">
          <h3>베니스</h3>
          <p><strong>여기는 베니스 !!!</strong></p>
        </div>      
      </div>
    
      <div class="item">
        <img src="images/만리장성001.jpg" alt="New York" style="max-width: 100%; height: 500px">
        <div class="carousel-caption">
          <h3>LA</h3>
          <p>여기는 중국</p>
        </div>      
      </div>
    </div>
    </div>
    <div>
     <div class="headerMenu">
        <ul>
           <li>
            <a href="#">QNA</a>
          </li>
           <li>
            <a href="#">이벤트</a>
          </li>
          <li>
            <a href="travelAbroad.mvc">해외여행</a>
          </li>
          <li>
            <a href="#">국내여행</a>
          </li>
          <li>
            <a href="#">게시판</a>
          </li>
          <li>
            <a href="#">공지사항</a>
          </li>
        </ul>
      </div>
    </div>
</header>