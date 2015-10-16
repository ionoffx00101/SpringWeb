<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>여기는 로그인을 하지</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(jqueryOk);
function jqueryOk() {
	
	$("button[name=sendemail]").on("click",function (evt){
        evt.preventDefault();
        $('#chatStatus').text('이메일을 보냈습니다');
        
		/* $.ajax({
			type : "post",
			url : "login",
			dataType : "json",
			data :  $('form').eq(0).serialize()
			,
			success : function(json) {
				if (json.check) {
					alert('이메일인증성공');
					$('#chatStatus').text('이메일인증완료');
				} else
					alert('이메일인증실패');
				$('#chatStatus').text('이메일인증을 다시 시도해주세요');
			},
			error : function(err) {
				alert("에러");
			}

		}); */
	});
}
</script>
</head>
<body>
	<form method="post" action="login">
		이메일 :<input type="text" name="email" required="required" value="tehon0318@naver.com">
		<button type="submit">이메일보내기</button>
<div id='chatStatus'></div>
	</form>
</body>
</html>