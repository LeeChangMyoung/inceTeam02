<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
  
  #sidebar-wrapper {
    /* position: fixed; */
    width: 20%;
    height: 100%;
    margin-left: -250px;
    
    background: #000;
    overflow-x: hidden;
    overflow-y: auto;
  }
  
  
  .sidebar-nav {
    width: 250px;
    margin: 0;
    padding: 0;
    list-style: none;
  }
  
  .sidebar-nav li {
    text-indent: 1.5em;
    line-height: 3.8em;
  }
  
  .sidebar-nav li a {
    display: block;
    text-decoration: none;
    color: #999;
  }
  
  .sidebar-nav li a:hover {
    color: #fff;
    background: rgba(255, 255, 255, 0.2);
  }
  
  .sidebar-nav > .sidebar-brand {
    font-size: 1.3em;
    line-height: 3em;
  } 

</style>



<div id="page-wrapper">
  <!-- 사이드바 -->
  <div id="sidebar-wrapper">
    <ul class="sidebar-nav">
      <li class="sidebar-brand">
      </li>
      <li><a href="#">해외여행</a></li>
      <li><a href="travelJapan.mvc?cNum=81">일본</a></li>
      <li><a href="#">동남아</a></li>
      <li><a href="#">유럽</a></li>
      <li><a href="travelChina.mvc?cNum=86">중국</a></li>
      <li><a href="#">러시아</a></li>
      <li><a href="#">미국</a></li>
      <li><a href="travelIndia.mvc?cNum=91">인도</a></li>
    </ul>
  </div>
  <!-- /사이드바 -->
</div>