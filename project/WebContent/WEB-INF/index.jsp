<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>


<!-- 헤더  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<!-- <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css"> -->
<link rel="stylesheet" type="text/css" href="css/imsi.css" />
<link rel="stylesheet" type="text/css" href="css/sidebar.css" />
<link rel="stylesheet" type="text/css" href="css/tpak.css" />
<!-- <link rel="stylesheet" type="text/css" href="../css/bootstrap.css.map" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" /> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>


<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); // 애니메이션
  
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>
</head>



<body>
	<div id="wrap">	
 		<%@ include file="pages/header.jsp" %>
 		<div class="clear"></div>	
		
		<c:if test="${not empty param.side }" >
			<%@ include file="pages/sidebar.jsp" %>
		</c:if>
						
		<c:if test="${ not empty param.body }">
			<jsp:include page="${ param.body }" />
		</c:if>
	
		<div class="clear"></div>		
		<%@ include file="pages/footer.jsp" %>
	</div> 
</body>
</html>