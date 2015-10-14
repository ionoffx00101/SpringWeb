<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">
$(jqueryOk);
function jqueryOk() {
	$('button').click(function(evt) {
		evt.preventDefault();
		$.ajax({
			type : "post",
			url : "login",
			dataType : "json",
			data :  $('form').eq(0).serialize()
			,
			success : function(json) {
				if (json.ok) {
					alert('로그인 성공');
					location.href="poket";
				} else
					alert('로그인 실패');
			},
			error : function(err) {
				alert("에러");
			}

		});
		
	});

}
</script>

</head>
<body>
<form action="login" method="post">
<table>
<tr><td>아이디</td><td><input name="id" type="text" value="7369"></td></tr>
<tr><td>비밀번호</td><td><input name="pw" type="password" value="SMITH"></td></tr>
</table>
<button type="button">로그인</button>
</form>
<br>로그인 용 아이디 디폴트 입력 되어 있음
<br>
7839 KING
<br>
7902 FORD
</body>
</html>