$(function(){
	$("#commend").click(function(){
		$.ajax({
			url : "recommend.ajax",
			type : "post",
			dataType :"json",
			data : {recommend:"recommend", no : $("#rNo").val()},
			success : function(data){
				alert("추천 !");
				$("#recom").text("("+data.recommend+")");
				$("#tank").text("("+data.thank+")");
			},
			error: function(xml,statusType, err){
				console.log(err);
			}
		});		
	}).hover(function(){
		$(this).css({cursor:"pointer"});
	});
	
	$("#thank").click(function(){
		$.ajax({
			url : "recommend.ajax",
			type : "post",
			dataType :"json",
			data : {recommend:"thank", no : $("#rNo").val()},
			success : function(data){
				alert("땡쿠~");
				$("#recom").text("("+data.recommend+")");
				$("#tank").text("("+data.thank+")");
			},
			error: function(xml,statusType, err){
				console.log(err);
			}
		});	
	}).hover(function(){
		$(this).css({cursor:"pointer"});
	});
	
	$("#replyWrite").hover(function(){
		$(this).css("cursor","pointer");
	});
	
	$("#replyWrite").click(function(){
		$("#replyForm").insertBefore("#replyTitle").slideToggle(300);
		//$("#inup").val("1");
		
	});
	
	$(document).on("submit", "#replyWriteForm", function(){	
		console.log("replyWriteForm 실행됨");
		var param = $(this).serialize();
		$.ajax({
			url:"replyWrite.ajax",
			type:"post",
			dataType:"json",
			data: param,
			success : function(data){
			
				$("#replyTable").empty();	
				$.each(data, function(i, v) {
					
					var date = new Date(v.regDate);
					var strDate = date.getFullYear() + "-" + ((date.getMonth() + 1 < 10) 
							? "0" + (date.getMonth() + 1) : (date.getMonth() + 1)) + "-"  
							+ date.getDate() + "-" + ((date.getHours() < 10) 
							? "0" + date.getHours() : date.getHours()) + ":" 
							+ (date.getMinutes() < 10 ? "0" + date.getMinutes() 
							: date.getMinutes()) + ":" + (date.getSeconds() < 10 
							? "0" + date.getSeconds() : date.getSeconds());	
					
					
					var result = 
						"<tr class='reply_" + v.no + "'>" 
						+ "<td>"
						+ "	<div class='replyUser'>"
						+ "		<span class='member'>" + v.writer + "</span>"
						+ "	</div>"
						+ "	<div class='replyModify'>"
						+ "		<span class='replyDate'>" + strDate + "</span>"
						+ "		<a href='#' class='modifyReply' data-no='" + v.no + "'>"
						+ "			<img src='img/reply_btn_modify.gif' alt='댓글 수정하기'/>"
						+ "		</a>"
						+ "		<a href='#' class='deleteReply' data-no='" + v.no + "'>"
						+ "			<img src='img/reply_btn_delete.gif' alt='댓글 삭제하기'/>"
						+ "		</a>"
						+ "		<a href='javascript:reportReply('div_" + v.no + "');'>"
						+ "			<img src='img/reply_btn_notify.gif' alt='신고하기'/>"
						+ "		</a>"
						+ "	</div>"
						+ "	<div class='replyContent' id='div_" + v.no + "'>"
						+ "		<pre><span>" + v.reply + "</span></pre>"
						+ "	</div>"
						+ "</td>"
					+ "</tr>";
							
					$("#replyTable").append(result);
				});
				$("#replyForm").slideUp(300);
				$("#replyContent").val("");
					
			},
			error : function(xml,statusType, err){
				console.log(err);
			}
		});
		return false;		
	});
	
	$(document).on("click", ".modifyReply", function(){
		console.log("클릭");
		var $next = $(this).parent().next();	
		var reply = $next.first().text();
		var replyno = $(this).attr("data-no");
		/*var replyContent = $("#replyContent").find(".content");*/
		/*alert(replyContent);*/
		if($("#replyForm").css("display") == 'block') {
			$("#replyForm").slideUp(300);
		}
		setTimeout(function() {				
			$("#replyContent").val($.trim(reply));
			$("#replyno").val(replyno);
			$("#replyForm").appendTo($next).slideDown(300);
		}, 300);
		$("#replyForm").find("form").attr({"id": "replyUpdateForm", "data-no": $(this).attr("data-no") });	
		return false;
	});
	
	$(document).on("submit", "#replyUpdateForm", function(){
		console.log("replyUpdateForm 실행됨");
		var param = $(this).serialize();
		$.ajax({
			url:"replyUpdate.ajax",
			type:"post",
			dataType:"json",
			data: param,
			success : function(data){
			
				var $updateForm = $("#replyForm");
				console.log("update - before empty() : " + $updateForm.length);
				
				$("#replyTable").empty();	
				
				$.each(data, function(i, v) {
					
					var date = new Date(v.regDate);
					var strDate = date.getFullYear() + "-" + ((date.getMonth() + 1 < 10) 
							? "0" + (date.getMonth() + 1) : (date.getMonth() + 1)) + "-"  
							+ date.getDate() + "-" + ((date.getHours() < 10) 
							? "0" + date.getHours() : date.getHours()) + ":" 
							+ (date.getMinutes() < 10 ? "0" + date.getMinutes() 
							: date.getMinutes()) + ":" + (date.getSeconds() < 10 
							? "0" + date.getSeconds() : date.getSeconds());	
					
					
					var result = 
						"<tr class='reply_" + v.no + "'>" 
						+ "<td>"
						+ "	<div class='replyUser'>"
						+ "		<span class='member'>" + v.writer + "</span>"
						+ "	</div>"
						+ "	<div class='replyModify'>"
						+ "		<span class='replyDate'>" + strDate + "</span>"
						+ "		<a href='#' class='modifyReply' data-no='" + v.no + "'>"
						+ "			<img src='img/reply_btn_modify.gif' alt='댓글 수정하기'/>"
						+ "		</a>"
						+ "		<a href='#' class='deleteReply' data-no='" + v.no + "'>"
						+ "			<img src='img/reply_btn_delete.gif' alt='댓글 삭제하기'/>"
						+ "		</a>"
						+ "		<a href='javascript:reportReply('div_" + v.no + "');'>"
						+ "			<img src='img/reply_btn_notify.gif' alt='신고하기'/>"
						+ "		</a>"
						+ "	</div>"
						+ "	<div class='replyContent' id='div_" + v.no + "'>"
						+ "		<pre><span>" + v.reply + "</span></pre>"
						+ "	</div>"
						+ "</td>"
					+ "</tr>";
							
					$("#replyTable").append(result);
				});
				
				console.log("update after empty() : #replyForm - " 
						+ $("#replyForm").length 
						+ ", $updateFrom : " + $updateForm.length);
				
				//$("#replyForm").slideUp(300);
				//$("#replyContent").val("");
				
				$updateForm.find("form")
				.attr("id", "replyWriteForm").removeAttr("data-no")
				.end().css("display", "none").appendTo("article")
				.find("#replyContent").val("");
				
				$("#replyUpdateForm").find("form")
				.attr({"id": "replyForm", "data-no": $(this).attr("data-no") });	
				
			},
			error : function(xml,statusType, err){
				console.log(err);
			}
		});
		return false;		
	});
	
	$(document).on("click", ".deleteReply", function(){
		var bbsNo = $("#rNo").val();
		var no = $(this).attr("data-no");
		var param = "bbsNo=" + bbsNo + "&no=" + no;
		
		$.ajax({
			url:"replyDelete.ajax",
			type:"post",
			dataType:"json",
			data: param,
			success : function(data){
				//console.log(data);
				$("#replyTable").empty();	
				$.each(data, function(i, v) {
					
					var date = new Date(v.regDate);
					var strDate = date.getFullYear() + "-" + ((date.getMonth() + 1 < 10) 
							? "0" + (date.getMonth() + 1) : (date.getMonth() + 1)) + "-"  
							+ date.getDate() + "-" + ((date.getHours() < 10) 
							? "0" + date.getHours() : date.getHours()) + ":" 
							+ (date.getMinutes() < 10 ? "0" + date.getMinutes() 
							: date.getMinutes()) + ":" + (date.getSeconds() < 10 
							? "0" + date.getSeconds() : date.getSeconds());	
					
					
					var result = 
						"<tr class='reply_" + v.no + "'>" 
						+ "<td>"
						+ "	<div class='replyUser'>"
						+ "		<span class='member'>" + v.writer + "</span>"
						+ "	</div>"
						+ "	<div class='replyModify'>"
						+ "		<span class='replyDate'>" + strDate + "</span>"
						+ "		<a href='#' class='modifyReply' data-no='" + v.no + "'>"
						+ "			<img src='img/reply_btn_modify.gif' alt='댓글 수정하기'/>"
						+ "		</a>"
						+ "		<a href='#' class='deleteReply' data-no='" + v.no + "'>"
						+ "			<img src='img/reply_btn_delete.gif' alt='댓글 삭제하기'/>"
						+ "		</a>"
						+ "		<a href='javascript:reportReply('div_" + v.no + "');'>"
						+ "			<img src='img/reply_btn_notify.gif' alt='신고하기'/>"
						+ "		</a>"
						+ "	</div>"
						+ "	<div class='replyContent' id='div_" + v.no + "'>"
						+ "		<pre><span>" + v.reply + "</span></pre>"
						+ "	</div>"
						+ "</td>"
					+ "</tr>";
							
					$("#replyTable").append(result);
				});
				$("replyForm").slideUp(300).add("#replyContent").val("");
			},
			error : function(xml,statusType, err){
				console.log(err);
			}			
		});
		return false;
	});
	
	
});