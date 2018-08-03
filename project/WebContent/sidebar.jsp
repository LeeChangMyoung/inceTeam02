<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>사이드바</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link rel="stylesheet" href="sidebar.css">

<style>

#page-content-wrapper {
    padding-left: 0;
    -webkit-transition: all 0.5s ease;
    -moz-transition: all 0.5s ease;
    -o-transition: all 0.5s ease;
    transition: all 0.5s ease;
}

/* 사이드 바 CSS */

#sidebar-wrapper{
  z-index:1;
  position: absolute;	
  width: 0;
  /* height: auto; */
  overflow-y:hidden;		/* 보모요소의 범위 넘어갈때 보이지 않도록 처리 */
  background:#FFA2A2;
  border: 2px solid red;
  opacity: 0.9;				/* 투명도 */

  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}



/*Chang the width of the sidebar to display it */

#wrapper.menuDisplayed #sidebar-wrapper{
  width: 200px;
}

/**/

#wrapper.menuDisplayed #page-content-wrapper{
  padding-left:250px;
}
 

/*sider styling*/
.sidebar-nav{
  padding: 0;
  list-style:none;
}

.sidebar-nav li{
  text-indent: 40px;
  line-height: 60px;
}
.sidebar-nav li a{
  display: block;
  text-decoration: none;
  color:#FFFFFF;
  /* text-shadow: 0 0 0 #fff; */
}
.sidebar-nav li a:hover{
  background:#A50000;

}
</style>

</head>
  <body>
	  <div id="wrapper ">
<!--sidebar-->
	  <div id="sidebar-wrapper">
    	<ul class="sidebar-nav">
      		<li><a hreg="#">일본</a></li>
      		<li><a hreg="#">중국</a></li>
      		<li><a hreg="#">동남아</a></li>
      		<li><a hreg="#">유럽</a></li>
    	</ul>
  	  </div>

<!--page content-->

<div id="page-content-wrapper">
  <div class="container-fluid">
    <div class="row">
      <div class="col-lg-12">
        <a href="#" class="btn btn-success" id="menu-toggle">버튼</a>
      </div>
    </div>
  </div>
</div>

  </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
