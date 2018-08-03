// 게시 글쓰기 폼 유효성 검사
$(function(){
	
$("#writeForm").on("click",function(){
	if($("#writer").val().length <= 0){
		alert("작성자가 입력되지 않았습니다.\n 작성자를 입력해 주세요");
		$("#writer").focus();
		return false;
	}
	
	
	if($("#title").val().length<=0){
		alert("제목이 입력되지 않았습니다.\n 제목을 입력해주세요");
		$("#title").focus();
		return false;
	}
	if($("#pass").val().length<=0){
		alert("비밀번호가 입력되지 않았습니다.\n 비밀번호를 입력해주세요");
		$("#pass").focus();
		return false;
	}
	if($("#content").val().length<=0){
		alert("내용이 입력되지 않았습니다.\n 내용을 입력해주세요");
		$("#content").focus();
		return false;
	}
	if($("#file").val().length<=0){
		var result = confirm("파일이 추가되지 않았습니다." 
				+ "\n 첨부파일 없이 글 등록하시겠습니까?");
		if(!result){
			$("#file").focus();
			return false;
			}
		}
	});
});