<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">

</head>

<style>
table { margin: 50px auto;
	padding: 0 0;	
	border-collapse: collapse;
	line-height: 200%;
	font-size: 1.1em;
	width : 760px;
	}

caption {
 font-size : 1.6em;
 font-style:  'Montserrat', 'Noto Sans KR', sans-serif; 
}
h2{
text-align : right;
}
.mypageheader{
margin : 100px 0px 10px 0px;
}

a { text-decoration: none; line-height: 200%; }

</style>
<body>
<div class="container">
	<div class="mypageheader"><h2>안녕하세요 name 님 즐거운 여행 되세요. <br/>
			당신의 마일리지는 ? 입니다.</h2>
	</div>

<table class ="table table-hover">
	<caption>나의 최근 예약 내역</caption>
	<tr>
  <th class="warning">예약일자</th>
  <th class="warning">상품명</th>
  <th class="warning">출발지역</th>
  <th class="warning">출발날짜</th>
  <th class="warning">도착날짜</th>
  <th class="warning">여행기간</th>
  <th class="warning">총금액</th>
  <th class="warning">결제하기</th>
	</tr>
	<tr>
  <th class="success">08-08-23</th>
  <th class="success"><a href ="#" target ="_blank" style="text-decoration: none ">오사카 3박 4일 여행</a></th>
  <th class="success">부산/서울</th>
  <th class="success">08-08-31</th>
  <th class="success">08-09-02</th>
  <th class="success">2박 3일</th>
  <th class="success">250,000</th>
  <th class="success"><button type="button" class="btn btn-success">결제</button></th>
	</tr>

</table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  
<script src="../js/bootstrap.min.js"></script>

</body>
</html>