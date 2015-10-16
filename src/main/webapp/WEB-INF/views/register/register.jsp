<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(jqueryOk);
function jqueryOk() {
	
	$("button[name=sendemail]").on("click",function (evt){
        evt.preventDefault();
       // $('#chatStatus').text('이메일을 보냈습니다');
		  $.ajax({
			type : "post",
			url : "../register/send",
			dataType : "json",
			data :  {"email":$("input[name=email]").val()}
			,
			success : function(json) {
				if (json.check) {
					$('#chatStatus').text('이메일인증보냄');
				} else{
				$('#chatStatus').text('이메일인증을 다시 시도해주세요');
				}
			},
			error : function(err) {
				alert("에러 : 다시 시도해주세요");
			}

		}); 
	});
	$("button[name=sendform]").on("click",function (evt){
        evt.preventDefault();
        
		  $.ajax({
			type : "post",
			url : "../register/allform",
			dataType : "json",
			data :  $('form').eq(0).serialize()
			,
			success : function(json) {
				if (json.check) {
					alert("회원가입완료");
					$('#link').css("display","none");
				} else{
					alert("회원가입실패");
				}
			},
			error : function(err) {
				alert("에러 : 다시 시도해주세요");
			}

		}); 
	});
	/* if($email.ok){
		
	} */
}
</script>
</head>
<body>
	<form ><!-- method="post" action="login" -->
		이메일 :<input type="text" name="email" required="required" value="tehon0318@naver.com"> 
		<button type="button" name="sendemail">이메일보내기 </button> ${emailok}<div id='chatStatus'></div>
 <c:if test="${emailok}">
	   아이디 :<input type="text" name="id" /><br>
비밀번호 :<input type="text" name="pw" /><br>
  이름 :<input type="text" name="name" /><br>
    <button type="button" name="sendform">회원가입</button>
</c:if>
	</form>
	
	<div id='link' style="display:block"><a href="http://192.168.8.55:8500/SpringWeb/register/list">리스트보기</a></div>
	
	
	
</body>
</html>