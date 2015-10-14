<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
}

table {
	display: inline-block;
	text-align: left;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
}

th {
	border: 1px solid black;
}
</style>
<script type="text/javascript" src="<c:url value="resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">

$(jqueryOk);
function jqueryOk() {
	$('button').click(function(evt) {
		evt.preventDefault();
		$.ajax({
			type : "post",
			url : "empInput",
			dataType : "json",
			data :  $('form').eq(0).serialize()
			,
			success : function(json) {
				if (json.ok) {
					alert('등록 성공');
					location.href="emplist"
				} else
					alert('등록 실패');
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
<form action="">
<table>
<tr><th>사번</th><td id="empno"><input name="empno" type="text"></td></tr>
<tr><th>이름</th><td><input name="ename" type="text"></td></tr>
<tr><th>부서번호</th><td><input name="deptno" type="text"></td></tr>
<tr><th>급료</th><td><input name="sal" type="text"></td></tr>
<tr><td><button id="input">등록하기</button></td></tr>
</table>
</form>
</body>
</html>